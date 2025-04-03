
CREATE TABLE tb_balance
(
  user_id BIGINT   NOT NULL COMMENT '사용자고유ID',
  balance BIGINT   NOT NULL DEFAULT 0 COMMENT '사용자별 보유 금액',
  reg_dt  DATETIME NOT NULL DEFAULT now() COMMENT '등록일',
  upd_dt  DATETIME NULL     COMMENT '수정일'
) COMMENT '보유금액';

CREATE TABLE tb_balance_history
(
  id           BIGINT   NOT NULL DEFAULT auto_increment COMMENT 'PK',
  user_id      BIGINT   NOT NULL COMMENT '사용자고유ID',
  amount       BIGINT   NOT NULL COMMENT '충전 또는 사용 금액',
  balance_type ENUM     NOT NULL COMMENT '1: 충전, 2: 사용',
  reg_dt       DATETIME NOT NULL DEFAULT now() COMMENT '등록일',
  PRIMARY KEY (id)
) COMMENT '사용자 금액 내역';

CREATE TABLE tb_coupon
(
  id            BIGINT   NOT NULL DEFAULT auto_increment COMMENT '쿠폰고유ID',
  discount_rate INT      NOT NULL DEFAULT 0 COMMENT '할인율',
  status        INT      NOT NULL DEFAULT 0 COMMENT '발급여부 1: 발급됨, 0: 발급전',
  reg_dt        DATETIME NOT NULL DEFAULT now() COMMENT '등록일',
  upd_dt        DATETIME NULL     COMMENT '수정일',
  PRIMARY KEY (id)
) COMMENT '선착순쿠폰';

CREATE TABLE tb_order
(
  id               BIGINT   NOT NULL DEFAULT auto_increment COMMENT '주문고유ID',
  user_id          BIGINT   NOT NULL COMMENT '사용자고유ID',
  coupon_id        BIGINT   NULL     COMMENT '쿠폰고유ID',
  order_price      BIGINT   NOT NULL DEFAULT 0 COMMENT '주문가격',
  last_order_price BIGINT   NOT NULL COMMENT '최종주문가격(쿠폰적용)',
  status           INT      NOT NULL DEFAULT 0 COMMENT '0: 대기, 1:성공, 2:실패',
  reg_dt           DATETIME NOT NULL DEFAULT now COMMENT '등록일',
  upd_dt           DATETIME NULL     COMMENT '수정일',
  PRIMARY KEY (id)
) COMMENT '주문';

CREATE TABLE tb_order_detail
(
  order_id       BIGINT   NOT NULL COMMENT '주문고유ID',
  product_id     BINGINT  NOT NULL COMMENT '상품ID',
  product_amount INT      NOT NULL DEFAULT 1 COMMENT '수량',
  reg_dt         DATETIME NOT NULL DEFAULT now COMMENT '등록일',
  PRIMARY KEY (order_id, product_id)
) COMMENT '주문상세';

CREATE TABLE tb_payment
(
  id             BIGINT NOT NULL COMMENT '결제고유ID',
  user_id        BIGINT NOT NULL COMMENT '사용자고유ID',
  payment_amount BIGINT NOT NULL COMMENT '결제금액',
  status         INT    NOT NULL DEFAULT 0 COMMENT '0:대기, 1:성공, 2:실패',
  PRIMARY KEY (id)
) COMMENT '결제';

CREATE TABLE tb_payment_detail
(
  payment_id BIGINT   NOT NULL COMMENT '결제고유ID',
  order_id   BIGINT   NOT NULL COMMENT '주문고유ID',
  reg_dt     DATETIME NOT NULL DEFAULT now COMMENT '등록일',
  PRIMARY KEY (payment_id, order_id)
) COMMENT '결제상세';

CREATE TABLE tb_product
(
  id    BIGINT       NOT NULL DEFAULT auto_increment COMMENT '상품고유ID',
  name  VARCHAR(255) NOT NULL DEFAULT "" COMMENT '상품명',
  price BIGINT       NOT NULL DEFAULT 0 COMMENT '가격',
  count INT          NOT NULL COMMENT '재고',
  PRIMARY KEY (id)
) COMMENT '상품';

CREATE TABLE tb_user
(
  id        BIGINT       NOT NULL COMMENT '사용자고유ID',
  name      VARCHAR(200) NOT NULL COMMENT '사용자명',
  coupon_id BIGINT       NOT NULL DEFAULT auto_increment COMMENT '쿠폰고유ID',
  reg_dt    DATETIME     NOT NULL DEFAULT now() COMMENT '등록일',
  PRIMARY KEY (id)
) COMMENT '사용자';
