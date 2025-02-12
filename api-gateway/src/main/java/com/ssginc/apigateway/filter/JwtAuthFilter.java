package com.ssginc.apigateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Base64;

@Slf4j
@Component
public class JwtAuthFilter implements WebFilter {

    private final Key key;

    public JwtAuthFilter(@Value("${jwt.secret}") String secretKey) {
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        this.key = Keys.hmacShaKeyFor(decodedKey);
        System.out.println("Key accepted and Running");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            log.warn("인증 실패: Authorization 헤더가 없습니다");
            return exchange.getResponse().setComplete();
        }

        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (token == null || !token.startsWith("Bearer ")) {
            log.warn("잘못된 인증 형식 입니다");
            return exchange.getResponse().setComplete();
        }

        //Bearer 부분없이 순수 JWT 토큰만 추출
        token = token.substring(7);


        if (!isValidToken(token)) {
            log.warn("유효하지 않은 JWT 토큰입니다");
            return exchange.getResponse().setComplete();
        }

        Claims claims = getClaimsFromToken(token);
        if (claims != null) {
            request = exchange.getRequest().mutate()
                    .header("X-User-Email", claims.getSubject())
                    .header("X-User-Role", claims.get("role", String.class))
                    .build();
        }

        return chain.filter(exchange.mutate().request(request).build());
    }

    private boolean isValidToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error("JWT 검증 실패: {}", e.getMessage());
            return false;
        }
    }

    private Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("JWT 에서 사용자 정보 추출 실패 {}", e.getMessage());
            return null;
        }
    }
}
