    ## e-커머스 서비스 시퀀스 다이어그램

## 목차

1. [잔액충전](#1-잔액충전)
2. [잔액조회](#2-잔액조회)
3. [상품조회](#3-상품조회)
4. [주문](#4-주문)
5. [결제](#5-결제)
6. [선착순쿠폰](#6-선착순쿠폰)
7. [인기판매상품조회](#7-인기판매상품조회)

<div style="page-break-after: always;"></div>

---


## 1. 잔액충전

```mermaid
%%{init: {"theme":"forest"}}%%
sequenceDiagram
autonumber
actor C_CLIENT as 클라이언트
participant C_CASH as 잔고
participant C_CASH_HISTORY as 잔고이력
participant C_USER as 사용자


%% 잔액충전
C_CLIENT ->> C_CASH : 잔액충전 요청
activate C_CASH
C_CASH ->> C_USER: 사용자 조회
activate C_USER
opt 사용자 존재 X
    C_USER ->> C_CLIENT : 사용자 미존재 예외
end
C_USER ->> C_CASH : 사용자 조회 완료
deactivate C_USER
opt 최대잔고 초과
    C_CASH ->> C_CLIENT: 최대 잔액 초과 예외
end
C_CASH ->> C_CASH: 잔액 충전

C_CASH ->> C_CASH_HISTORY: 잔액 충전 이력 저장
activate C_CASH_HISTORY
C_CASH_HISTORY ->> C_CASH: 잔액 충전 이력 저장 완료
deactivate C_CASH_HISTORY

C_CASH ->> C_CLIENT : 잔액충전 성공
deactivate C_CASH
```

<div style="page-break-after: always;"></div>

---


## 2. 잔액조회

```mermaid
%%{init: {"theme":"forest"}}%%
sequenceDiagram
autonumber
actor C_CLIENT as 클라이언트
participant C_CASH as 잔고
participant C_USER as 사용자


%% 잔액조회
C_CLIENT ->> C_CASH : 잔액조회 요청
activate C_CASH
C_CASH ->> C_USER: 사용자 조회
activate C_USER
opt 사용자 존재 X
    C_USER ->> C_CLIENT : 사용자 미존재 예외
end
C_USER ->> C_CASH : 사용자 조회 완료
deactivate C_USER
C_CASH ->> C_CASH: 잔액 조회
C_CASH ->> C_CLIENT : 잔액조회 성공
deactivate C_CASH

```
<div style="page-break-after: always;"></div>

---


## 3. 상품조회
```mermaid
%%{init: {"theme":"forest"}}%%
sequenceDiagram
autonumber
actor C_CLIENT as 클라이언트
participant C_PRODUCTION as 상품

%% 상품조회
C_CLIENT ->> C_PRODUCTION : 상품조회 요청
activate C_PRODUCTION
C_PRODUCTION ->> C_CLIENT : 상품조회 응답
deactivate C_PRODUCTION

```
<div style="page-break-after: always;"></div>

---


## 4. 주문
```mermaid
%%{init: {"theme":"forest"}}%%
sequenceDiagram
autonumber
actor C_CLIENT as 클라이언트
participant C_ORDER as 주문
participant C_PRODUCTION as 상품
participant C_USER as 사용자


%% 주문
C_CLIENT ->> C_ORDER : 주문 요청
activate C_ORDER
C_ORDER ->> C_USER: 사용자 조회
activate C_USER
opt 사용자 존재 X
    C_USER ->> C_CLIENT : 사용자 미존재 예외
end
C_USER ->> C_ORDER : 사용자 조회 완료
deactivate C_USER
C_ORDER ->> C_PRODUCTION: 상품 조회
activate C_PRODUCTION

deactivate C_PRODUCTION
deactivate C_ORDER
```
<div style="page-break-after: always;"></div>

---

## 5. 결제
```mermaid
%%{init: {"theme":"forest","logLevel":"fatal","securityLevel":"strict","startOnLoad":true,"arrowMarkerAbsolute":false,"htmlLabels":true,"sequence":{"useMaxWidth":true,"actorMargin":80,"mirrorActors":false,"showSequenceNumbers":true}}}%%
sequenceDiagram

participant C_CLIENT as 사용자
participant C_PRODUCTION as 상품
participant C_ORDER as 주문
participant C_PAYMENT as 결제

%% 결제
C_CLIENT ->> C_PRODUCTION : 상품조회 요청
activate C_PRODUCTION
C_PRODUCTION ->> C_CLIENT : 상품조회 응답<br/>- 재고
deactivate C_PRODUCTION
alt 상품재고>=1
C_CLIENT ->> C_ORDER : 주문요청
activate C_ORDER
C_ORDER ->> C_CLIENT: 주문응답
deactivate C_ORDER
end
alt 주문성공
activate C_PAYMENT
alt 쿠폰적용
    C_CLIENT ->> C_PAYMENT: 결제요청
    C_PAYMENT ->> C_CLIENT: 결제응답
end
alt 쿠폰적용X
    C_CLIENT ->> C_PAYMENT: 결제요청
    C_PAYMENT ->> C_CLIENT: 결제응답
end
end
deactivate C_PAYMENT

```
<div style="page-break-after: always;"></div>

---

## 6. 선착순쿠폰
```mermaid
%%{init: {"theme":"forest","logLevel":"fatal","securityLevel":"strict","startOnLoad":true,"arrowMarkerAbsolute":false,"htmlLabels":true,"sequence":{"useMaxWidth":true,"actorMargin":80,"mirrorActors":false,"showSequenceNumbers":true}}}%%
sequenceDiagram

participant C_CLIENT as 사용자
participant C_COUPON as 쿠폰

%% 선착순쿠폰
C_CLIENT ->> C_COUPON : 쿠폰발급 요청
activate C_COUPON
alt 쿠폰 개수 >= 1
C_COUPON ->> C_CLIENT : 사용자당 쿠폰 1장 발급
end
deactivate C_COUPON

```
<div style="page-break-after: always;"></div>

---

## 7. 인기판매상품조회
```mermaid
%%{init: {"theme":"forest","logLevel":"fatal","securityLevel":"strict","startOnLoad":true,"arrowMarkerAbsolute":false,"htmlLabels":true,"sequence":{"useMaxWidth":true,"actorMargin":80,"mirrorActors":false,"showSequenceNumbers":true}}}%%
sequenceDiagram

participant C_CLIENT as 사용자
participant C_PRODUCTION as 상품

%% 인기판매상품조회
C_CLIENT ->> C_PRODUCTION : 인기판매상품조회 요청
activate C_PRODUCTION
C_PRODUCTION ->> C_CLIENT : 최근 3일간 가장 많이 팔린 상위 5개 상품 정보를 제공
deactivate C_PRODUCTION

```
<div style="page-break-after: always;"></div>

---