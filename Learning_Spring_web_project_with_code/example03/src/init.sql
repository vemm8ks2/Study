// ���̺� ����
CREATE SEQUENCE seq_board; // ������ ���� �� DB�� �ٸ� ������Ʈ��� �����ϱ� ������ 'seq_'�� ���� �����ϴ� ���� �Ϲ����̴�.

CREATE TABLE tbl_board( // ���̺� ���� �� 'tbl_�� �����ϰų� 't_'�� ���� ������ ������ �ܾ �տ� �ٿ��ִ� ���� ����.'
    bno NUMBER(10, 0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT sysdate,
    updatedate DATE DEFAULT sysdate
);

ALTER TABLE tbl_board ADD CONSTRAINT pk_board PRIMARY KEY(bno);

// ���� ������ ����
INSERT INTO tbl_board (bno, title, content, writer) VALUES (seq_board.nextval, '�׽�Ʈ ����', '�׽�Ʈ ����', 'user00');
INSERT INTO tbl_board (bno, title, content, writer) VALUES (seq_board.nextval, '�׽�Ʈ ����', '�׽�Ʈ ����', 'user01');
INSERT INTO tbl_board (bno, title, content, writer) VALUES (seq_board.nextval, '�׽�Ʈ ����', '�׽�Ʈ ����', 'user02');
INSERT INTO tbl_board (bno, title, content, writer) VALUES (seq_board.nextval, '�׽�Ʈ ����', '�׽�Ʈ ����', 'user03');
INSERT INTO tbl_board (bno, title, content, writer) VALUES (seq_board.nextval, '�׽�Ʈ ����', '�׽�Ʈ ����', 'user04');

COMMIT;

// ���̺� ���� �� ���� ������ ���� �� ��ȸ
SELECT * FROM tbl_board;

// 8.1.2
SELECT * FROM tbl_board WHERE bno > 0;

// 12.1.1
-- ��� ���縦 ���ؼ� �������� ������ �ø���. �ݺ��ؼ� ���� �� ����
INSERT INTO tbl_board (bno, title, content, writer)
(SELECT seq_board.nextval, title, content, writer FROM tbl_board);

// 17.2
CREATE TABLE tbl_reply (
    rno NUMBER(10, 0),
    bno NUMBER(10, 0) NOT NULL,
    reply VARCHAR2(1000) NOT NULL,
    replyer VARCHAR2(50) NOT NULL,
    replyDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_reply;

ALTER TABLE tbl_reply ADD CONSTRAINT pk_reply PRIMARY KEY (rno);

ALTER TABLE tbl_reply ADD CONSTRAINT fk_reply_board FOREIGN KEY (bno) REFERENCES tbl_board (bno);

// 17.6.1 �����ͺ��̽��� �ε��� ����
CREATE INDEX idx_reply ON tbl_reply (bno DESC, rno ASC);