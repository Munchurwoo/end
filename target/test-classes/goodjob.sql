-- 회원 ( ERD에서 기업/개인 구분하기위해 type 컬럼을 뒀으나 명령어라 사용불가함 따라서 member_type으로 변경
create table member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	email varchar2(100) not null,
	name varchar2(100) not null,
	tel varchar2(100) not null,
	member_type number, --0은 관리자 / 1 은 개인회원 / 2 는 기업회원 승인 X / 3은 기업회원 승인 OK
	address varchar2(100) not null
)
drop table member;
---------------------------------------------------------------------

-- 관리자
create table manager(
	id varchar2(100) primary key,
	manager_level varchar2(100) not null,
	constraint fk_member_manager foreign key(id) references member(id)
)
drop table manager;
---------------------------------------------------------------------

-- 일반회원 
create table normal_member(
	normal_id varchar2(100) primary key,
	sex varchar2(100) not null,
	picture_path varchar2(100) not null,
	career_status varchar2(100) not null,
	constraint fk_normalandmember foreign key(normal_id) references member(id)
	
)
drop table normal_member;
---------------------------------------------------------------------

-- 포트폴리오
create table portfolio(
	normal_id varchar2(100) primary key,
	content varchar2(100) not null,
	constraint fk_member_portfolio foreign key(normal_id) references normal_member(normal_id) 
)
drop table portfolio;
---------------------------------------------------------------------

-- 포트폴리오 파일 경로 
create table portfolio_file(
	normal_id varchar2(100) primary key,
	file_path varchar2(100) not null,
	constraint fk_member_portfolio_file foreign key(normal_id) references portfolio(normal_id)
)
drop table portfolio_file;
---------------------------------------------------------------------

-- 기업회원
create table company_member(
	company_id varchar2(100) primary key,
	introduction varchar2(100) not null,
	company_type number not null,
	industry varchar2(100) not null,
	sales number default 0,
	date_of_establishment varchar2(100) not null,
	num_of_employees number not null,
	constraint fk_member_company_member foreign key(company_id) references member(id)
)
drop table company_member;
---------------------------------------------------------------------

-- 구인공고와  PK시퀀스
create table job_posting(
	job_posting_num number primary key,
	company_id varchar2(100),
	career_status varchar2(100) not null,
	content varchar2(1000) not null,
	constraint fk_company_member_job_posting foreign key(company_id) references company_member(company_id)
)
create sequence job_posting_num_seq;

drop sequence job_posting_num_seq;
drop table job_posting;
---------------------------------------------------------------------

-- 키워드
create table keyword(
	keyword_name varchar2(100) primary key
)
drop table keyword;
---------------------------------------------------------------------

--구인공고와 키워드 복합키
create table job_posting_keyword(
	keyword_name varchar2(100),
	job_posting_num number,
	constraint fk_job_posting_num foreign key(job_posting_num) references job_posting(job_posting_num),
	constraint fk_keyword foreign key(keyword_name) references keyword(keyword_name),
	constraint pk_keywordname_jobpostingnum primary key(keyword_name,job_posting_num)
)
drop table job_posting_keyword;
---------------------------------------------------------------------

-- 질의응답과 구인공고게시글/아이디 복합키 설정
create table question_answer(
	normal_id varchar2(100),
	job_posting_num number,
	question varchar2(200) not null,
	answer varchar2(500) not null,
	constraint fk_member_qna foreign key(normal_id) references normal_member(normal_id),
	constraint fk_job_posting_num_qna foreign key(job_posting_num) references job_posting(job_posting_num),
	constraint pk_jobqna_memberqna primary key(normal_id,job_posting_num)
)
drop table question_answer;
---------------------------------------------------------------------

--모집직군분류와 PK 시퀀스
create table recruitment_category(
	rc_num number primary key,
	rc_name varchar2(100) not null
)
create sequence rc_num_seq;

drop table recruitment_category;
drop sequence rc_num_seq;
---------------------------------------------------------------------

-- 모집직군분류와 구인공고글 복합키 설정
create table job_recruitment(
	rc_num number,
	job_posting_num number,
	constraint fk_rc foreign key(rc_num) references recruitment_category(rc_num),
	constraint fk_job_posting_num2 foreign key(job_posting_num) references job_posting(job_posting_num),
	constraint pk_jobpostingnum_rcnum primary key (rc_num,job_posting_num)
)
drop table job_recruitment;
---------------------------------------------------------------------

-- 모집직군분류와 구직회원 복합키 설정
create table portfolio_recruitment(
	rc_num number,
	normal_id varchar2(100),
	constraint fk_rc_pf foreign key(rc_num) references recruitment_category(rc_num),
	constraint fk_id_pf foreign key(normal_id) references portfolio(normal_id),
	constraint pk_id_rc_pf primary key(rc_num,normal_id)
)
drop table portfolio_recruitment;
---------------------------------------------------------------------

-- 고용형태종류와 PK 시퀀스
create table employment_type_category(
	emp_type_num number primary key,
	emp_type_name varchar2(100) not null
)

create sequence emp_type_num_seq;

drop table employment_type_category;
drop sequence emp_type_num_seq;
---------------------------------------------------------------------

-- 고용형태종류와 구인공고글 복합키 설정
create table job_emp(
	emp_type_num number,
	job_posting_num number,
	constraint fk_emp_job foreign key(emp_type_num) references employment_type_category(emp_type_num),
	constraint fk_job_posting_num3 foreign key(job_posting_num) references job_posting(job_posting_num),
	constraint pk_jobposting_jobemp primary key(emp_type_num,job_posting_num)
)

drop table job_emp;
---------------------------------------------------------------------

-- 고용형태종류와 구직회원 복합키 설정
create table portfolio_emp(
	emp_type_num number,
	normal_id varchar2(100),
	constraint fk_emp_pf foreign key(emp_type_num) references employment_type_category(emp_type_num),
	constraint fk_id_emp foreign key(normal_id) references portfolio(normal_id),
	constraint pk_id_emp_pf primary key(emp_type_num,normal_id)
)
drop table portfolio_emp;
---------------------------------------------------------------------

-- 지역분류와 PK 시퀀스
create table location(
	loc_num number primary key,
	loc_name varchar2(100) not null
)
create sequence loc_num_seq;

drop table location;
drop sequence loc_num_seq;
---------------------------------------------------------------------

-- 지역종류와 구인공고글 복합키 설정
create table job_loc(
	loc_num number,
	job_posting_num number,
	constraint fk_loc_job foreign key(loc_num) references location(loc_num),
	constraint fk_job_posting_num4 foreign key(job_posting_num) references job_posting(job_posting_num),
	constraint pk_jobposting_jobloc primary key(loc_num,job_posting_num)
)

drop table job_loc;
----------------------------------------------------------------------

--지역종류와 구직회원 복합키 설정
create table portfolio_loc(
	loc_num number,
	normal_id varchar2(100),
	constraint fk_loc_pf foreign key(loc_num) references location(loc_num),
	constraint fk_id_loc foreign key(normal_id) references portfolio(normal_id),
	constraint pk_id_loc_pf primary key(loc_num,normal_id)
)
drop table portfolio_loc;
-----------------------------------------------------------------------

-- 개발분야와 PK 시퀀스
create table development_category(
	dev_cat_num number primary key,
	dev_cat_name varchar2(100) not null
)

create sequence dev_cat_num_seq;

drop table development_category;
drop sequence dev_cat_num_seq;
----------------------------------------------------------------------

-- 개발분야와 구인공고글 복합키 설정
create table job_dev(
	dev_cat_num number,
	job_posting_num number,
	constraint fk_dev_job foreign key(dev_cat_num) references development_category(dev_cat_num),
	constraint fk_job_posting_num5 foreign key (job_posting_num) references job_posting(job_posting_num),
	constraint pk_jobposting_jobdev primary key(dev_cat_num,job_posting_num)
)

drop table job_dev;
----------------------------------------------------------------------

-- 개발분야와 구직회원 복합키 설정
create table portfolio_dev(
	dev_cat_num number,
	normal_id varchar2(100),
	constraint fk_dev_pf foreign key(dev_cat_num) references development_category(dev_cat_num),
	constraint fk_id_dev foreign key(normal_id) references portfolio(normal_id),
	constraint pk_id_dev_pf primary key(dev_cat_num,normal_id)
)
drop table portfolio_dev;
----------------------------------------------------------------------

-- 학력구분과 PK 시퀀스
create table academic_category(
	academic_num number primary key,
	academic_name varchar2(100) not null
)
create sequence academic_num_seq;

drop table academic_category;
drop sequence academic_num_seq;
----------------------------------------------------------------------

-- 학력구분과 구인공고글 복합키 설정
create table job_academic(
	academic_num number,
	job_posting_num number,
	constraint fk_academic_job foreign key(academic_num) references academic_category(academic_num),
	constraint fk_job_posting_num6 foreign key(job_posting_num) references job_posting(job_posting_num),
	constraint pk_jobposting_jobacademic primary key(academic_num,job_posting_num)
)
drop table job_academic;
----------------------------------------------------------------------

-- 학력구분과 구직회원 복합키 설정
create table portfolio_academic(
	academic_num number,
	normal_id varchar2(100),
	constraint fk_aca_pf foreign key(academic_num) references academic_category(academic_num),
	constraint fk_id_aca foreign key(normal_id) references portfolio(normal_id),
	constraint pk_id_aca_pf primary key(academic_num,normal_id)
)
drop table portfolio_academic;