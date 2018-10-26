drop table member cascade constraint;
drop table manager cascade constraint;
drop table normal_member cascade constraint;
drop table portfolio cascade constraint;
drop table portfolio_file cascade constraint;
drop table company_member cascade constraint;
drop table job_posting cascade constraint;
drop table job_posting_keyword cascade constraint;
drop table question_answer cascade constraint;
drop table recruitment_category cascade constraint;
drop table job_recruitment cascade constraint;
drop table portfolio_recruitment cascade constraint;
drop table employment_type_category cascade constraint;
drop table job_emp cascade constraint;
drop table portfolio_emp cascade constraint;
drop table location_category cascade constraint;
drop table job_loc cascade constraint;
drop table portfolio_loc cascade constraint;
drop table development_category cascade constraint;
drop table job_dev cascade constraint;
drop table portfolio_dev cascade constraint;
drop table academic_category cascade constraint;
drop table job_academic cascade constraint;
drop table portfolio_academic cascade constraint;
drop table interview cascade constraint;

drop sequence job_posting_num_seq;
drop sequence academic_num_seq;
drop sequence dev_cat_num_seq;
drop sequence loc_num_seq;
drop sequence emp_type_num_seq;
drop sequence rc_num_seq;
drop sequence qa_num_seq;
drop sequence portfolio_file_seq;
drop sequence interview_num_seq;

		


-- 회원 ( ERD에서 기업/개인 구분하기위해 type 컬럼을 뒀으나 명령어라 사용불가함 따라서 member_type으로 변경
create table member(
   id varchar2(100) primary key,
   password varchar2(100) not null,
   email varchar2(100) not null,
   name varchar2(100) not null,
   address varchar2(100) not null,
   tel varchar2(100) not null,
   member_type number --0은 관리자 / 1 은 개인회원 / 2 는 기업회원 승인 X / 3은 기업회원 승인 OK
);

insert into MEMBER(id, password, email, name, address, tel, member_type) values('admin', 'admin', 'admin@kosta.or.kr', '관리자', '경기도 성남시 분당구 대왕판교로 670길 유스페이스2 B동 8층', '070-5039-5803, 5805', 0);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('NHNuser', '123', 'NHNuser@nhn.co.kr', 'NHNEntertainment', '경기도 성남시 분당구 대왕판교로 645번길 16 NHN엔터테인먼트 플레이뮤지엄', '031-8028-3221', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('qqqq', '123', 'qqqq@gmail.com', '이동규', '충청도 당진시', '010-1111-1111', 1);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('miri', '123', 'miri@gmail.com', '서미리', '경기도 성남시 중원구', '010-2222-2222', 1);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('yosep', '123', 'yosep@gmail.com', '최요셉', '경기도 수원시', '010-3333-3333', 1);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('hsj', '123', 'hsj@gmail.com', '황성진', '경기도 안양시', '010-4444-4444', 1);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('MCW', '123', 'MCW@gmail.com', '문철우', '서울특별시 중랑구', '010-5555-5555', 1);

select * from member;
---------------------------------------------------------------------
 
-- 관리자
create table manager(
   id varchar2(100) primary key,
   manager_level varchar2(100) not null,
   constraint fk_member_manager foreign key(id) references member(id) on delete cascade
);

insert into MANAGER(id, manager_level) values('admin', 1);

select * from manager;
---------------------------------------------------------------------

-- 개인회원 
create table normal_member(
   normal_id varchar2(100) primary key,
   gender varchar2(100) not null,
   career_status varchar2(100) not null,
   constraint fk_normalandmember foreign key(normal_id) references member(id) on delete cascade
);

insert into NORMAL_MEMBER(normal_id,  career_status, gender) values('qqqq', 'Java 개발자로 LINE에서 3년 근무', '남');
insert into NORMAL_MEMBER(normal_id,  career_status, gender) values('miri',  '.NET(C#) 개발 경력 2년 (마이다시아이티)', '여');
insert into NORMAL_MEMBER(normal_id, career_status, gender) values('yosep',  '없음', '남');
insert into NORMAL_MEMBER(normal_id,  career_status, gender) values('hsj',  'Oracle DBA 6년', '남');
insert into NORMAL_MEMBER(normal_id,  career_status, gender) values('MCW', 'Python 개발 5년 (네이버)', '남');

select * from normal_member;
---------------------------------------------------------------------

-- 포트폴리오
create table portfolio(
   normal_id varchar2(100) primary key,
   title varchar2(100) not null,
   content varchar2(1000) not null,
   picture_path varchar2(100) not null,
   constraint fk_member_portfolio foreign key(normal_id) references normal_member(normal_id) on delete cascade
);

insert into PORTFOLIO(normal_id, title, content, picture_path) values('yosep', 'Coder가 아닌 Developer가 되겠습니다.', '항상 배움의 자세로 새로운 분야에 도전하고 있으며, 매사에 도전하고 노력하는 인재입니다.', '최요셉.png');
insert into PORTFOLIO(normal_id, title, content, picture_path) values('MCW', '인재를 싸게 팝니다.', '주변 사람과 소통하며 혁신을 이뤄내는 사원이 되겠습니다.', '문철우.png');
insert into PORTFOLIO(normal_id, title, content, picture_path) values('miri', 'Coder가 아닌 Developer가 되겠습니다.', '항상 배움의 자세로 새로운 분야에 도전하고 있으며, 매사에 도전하고 노력하는 인재입니다.', 'miri.png');
insert into PORTFOLIO(normal_id, title, content, picture_path) values('hsj', '인재를 싸게 팝니다.', '주변 사람과 소통하며 혁신을 이뤄내는 사원이 되겠습니다.', '황성진.jpg');
insert into PORTFOLIO(normal_id, title, content, picture_path) values('qqqq', 'Coder가 아닌 Developer가 되겠습니다.', '항상 배움의 자세로 새로운 분야에 도전하고 있으며, 매사에 도전하고 노력하는 인재입니다.', '엔시소.png');
select * from interview;
select * from normal_member;
select * from company_member;
select * from interview;

update PORTFOLIO set picture_path='miri.png' where normal_id='miri';
---------------------------------------------------------------------

-- 포트폴리오 파일 경로 
create table portfolio_file(
   file_num number primary key,
   normal_id varchar2(100) not null,
   file_path varchar2(100) not null,
   constraint fk_member_portfolio_file foreign key(normal_id) references portfolio(normal_id) on delete cascade
);
create sequence portfolio_file_seq start with 601;

insert into PORTFOLIO_FILE(file_num, normal_id, file_path) values(portfolio_file_seq.nextval, 'yosep', '물품공유플랫폼.pdf');
insert into PORTFOLIO_FILE(file_num, normal_id, file_path) values(portfolio_file_seq.nextval, 'yosep', '소셜다이닝(sharebob).pptx');
insert into PORTFOLIO_FILE(file_num, normal_id, file_path) values(portfolio_file_seq.nextval, 'MCW', 'GoodJob.pdf');

select * from portfolio_dev;

---------------------------------------------------------------------

-- 기업회원
create table company_member(
   company_id varchar2(100) primary key,
   introduction varchar2(100) not null,
   company_type varchar2(100) not null,
   industry varchar2(100) not null,
   sales number default 0,
   date_of_establishment varchar2(100) default null,
   num_of_employees number default 0,
   picture_path varchar2(100) not null,
   constraint fk_member_company_member foreign key(company_id) references member(id) on delete cascade
);

insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, sales, date_of_establishment, num_of_employees,picture_path) values('NHNuser', '더 넓은 세상, 더 많은 사람들이 더 큰 재미를 우리와 함께 나눕니다.', '대기업', '솔루션', 1813, '2015-11-18', 664,'로고로고');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358,'로고로고');

select * from company_member;
---------------------------------------------------------------------

-- 구인공고와  PK시퀀스
create table job_posting(
   job_posting_num number primary key,
   company_id varchar2(100),
   career_status varchar2(100) not null,
   title varchar2(100) not null,
   content varchar2(1000) not null,
   constraint fk_company_member_job_posting foreign key(company_id) references company_member(company_id) on delete cascade
);
create sequence job_posting_num_seq start with 1001;

insert into JOB_POSTING(job_posting_num, company_id, career_status, title, content) values(job_posting_num_seq.nextval, 'NHNuser', '경력 3년4', 'NHN엔터테인먼트에서 Java 신입, 프리랜서 개발자 모집', 'Java 어플리케이션 개발 경험자, WAS 이해도가 높은 경험자 우대합니다.');
insert into JOB_POSTING(job_posting_num, company_id, career_status, title, content) values(job_posting_num_seq.nextval, 'Tmaxuser', '경력 무관', '티맥스소프트 DBA 2018 하반기 공개채용', 'MS-SQL 서버 모니터링 및 트러블 슈팅경험 있으신 분, OLTP 업무 경험 있으신 분');
insert into JOB_POSTING(job_posting_num, company_id, career_status, title, content) values(job_posting_num_seq.nextval, 'NHNuser', '경력 3년', 'NHN엔터테인먼트에서 Java 신입, 프리랜서 개발자 모집합니다  ', 'Java 어플리케이션 개발 경험자ㅎㅎㅎㅎㅎ, WAS 이해도가 높은 경험자 우대합니다테스트입니당.');

select * from job_posting;
---------------------------------------------------------------------

-- 키워드 삭제(MIRI 2018.10.12)
--create table keyword(
--   keyword_name varchar2(100),
--   constraint fk_job_keyword foreign key(job_posting_num) references job_posting(job_posting_num),
--   constraint pk_keyword_num_name primary key(job_posting_num, keyword_name)
--)
--drop table keyword cascade constraint;
--
--select * from keyword;
---------------------------------------------------------------------

--구인공고번호와 키워드 복합키
create table job_posting_keyword(
   job_posting_num number,
   keyword_name varchar2(100),
   constraint fk_job_posting_num foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade, 
   constraint pk_keywordname_jobpostingnum primary key(keyword_name,job_posting_num)
);

insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1001, '워라밸');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1001, '야근 없음');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1001, '근면 성실');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1002, '워라밸');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1002, 'Spring');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1002, '열정');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1002, '수평적 문화');
insert into JOB_POSTING_KEYWORD(job_posting_num, keyword_name) values(1002, '야근 없음');

select * from interview;
---------------------------------------------------------------------
create table interview(
	interview_num number primary key,
	normal_id varchar2(100),
	company_id varchar2(100),
	job_posting_num number,
	title varchar2(100) not null,
	content varchar2(100) not null,
	constraint fk_member_interview foreign key(normal_id) references normal_member(normal_id) on delete set null,
	constraint fk_comapny foreign key(company_id) references company_member(company_id) on delete set null,
	constraint fk_job_posting_interview_num foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade
);
create sequence interview_num_seq start with 2001;


insert into interview(interview_num, normal_id ,job_posting_num, title, content) values(interview_num_seq.nextval, 'hsj',1003 ,'면접신청합니다', '언제갈까요?');
insert into interview(interview_num, normal_id ,job_posting_num, title, content) values(interview_num_seq.nextval, 'qqqq',1003 ,'면접보러갈게요', '불러주세요~!~!~!');
insert into interview(interview_num, normal_id ,job_posting_num, title, content) values(interview_num_seq.nextval, 'miri', 1002,'포트폴리오확인하시고 연락주세요', '내일가겠습니다~');
insert into interview(interview_num, normal_id ,job_posting_num, title, content) values(interview_num_seq.nextval, 'yosep', 1002,'꼭 가고싶습니다~!', '전화번호로 연락주세요~');



-- 질의응답과 구인공고게시글/아이디 복합키 설정
create table question_answer(
   qa_num number primary key,
   normal_id varchar2(100),
   job_posting_num number,
   question varchar2(200) not null,
   answer varchar2(500) default null,
   constraint fk_member_qna foreign key(normal_id) references normal_member(normal_id) on delete set null,
   constraint fk_job_posting_num_qna foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade
);
create sequence qa_num_seq start with 701;

insert into QUESTION_ANSWER(qa_num, normal_id, job_posting_num, question, answer) values(qa_num_seq.nextval, 'qqqq', 1001, '수습기간이 따로 있나요?', '3개월의 수습기간을 거치게 됩니다.');
insert into QUESTION_ANSWER(qa_num, normal_id, job_posting_num, question, answer) values(qa_num_seq.nextval, 'qqqq', 1001, '정확한 채용 인원이 몇 명인가요?', '5명입니다.');
insert into QUESTION_ANSWER(qa_num, normal_id, job_posting_num, question, answer) values(qa_num_seq.nextval, 'miri', 1001, '중식은 어떻게 지원되나요?', '중식은 따로 지원되지 않습니다.');
insert into QUESTION_ANSWER(qa_num, normal_id, job_posting_num, question, answer) values(qa_num_seq.nextval, 'miri', 1002, '가장 자랑할만한 복리후생은 어떻게 되나요?', '탄력 근무제로 출퇴근 시간의 조정이 가능합니다.');
insert into QUESTION_ANSWER(qa_num, normal_id, job_posting_num, question, answer) values(qa_num_seq.nextval, 'qqqq', 1002, '졸업 예정자도 지원 가능한가요?', '네. 가능합니다.');

select * from question_answer;
---------------------------------------------------------------------

--모집직군분류와 PK 시퀀스
create table recruitment_category(
   rc_num number primary key,
   rc_name varchar2(100) not null
);
create sequence rc_num_seq start with 101;

insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, '웹 프로그래머');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, '응용 프로그래머');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, '시스템 프로그래머');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, 'HTML/퍼블리싱/UI');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, '네트워크/서버/보안');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, 'DBA/데이터베이스');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, '게임');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, '인공지능/빅데이터');
insert into RECRUITMENT_CATEGORY(rc_num, rc_name) values(rc_num_seq.nextval, 'ERP');

select * from recruitment_category;
---------------------------------------------------------------------

-- 모집직군분류와 구인공고글 복합키 설정
create table job_recruitment(
   job_posting_num number,
   rc_num number,
   constraint fk_job_posting_num2 foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade,
   constraint fk_rc foreign key(rc_num) references recruitment_category(rc_num) on delete cascade,
   constraint pk_jobpostingnum_rcnum primary key (rc_num,job_posting_num)
);

insert into JOB_RECRUITMENT(job_posting_num, rc_num) values(1001, 101);
insert into JOB_RECRUITMENT(job_posting_num, rc_num) values(1001, 105);
insert into JOB_RECRUITMENT(job_posting_num, rc_num) values(1002, 106);

select * from job_recruitment;
---------------------------------------------------------------------

-- 모집직군분류와 구직회원 복합키 설정
create table portfolio_recruitment(
   normal_id varchar2(100),
   rc_num number,
   constraint fk_id_pf foreign key(normal_id) references portfolio(normal_id) on delete cascade,
   constraint fk_rc_pf foreign key(rc_num) references recruitment_category(rc_num) on delete cascade,
   constraint pk_id_rc_pf primary key(rc_num,normal_id)
);

insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('yosep', 101);
insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('yosep', 106);
insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('MCW', 101);
insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('MCW', 108);
insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('qqqq', 107);
insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('miri', 103);
insert into PORTFOLIO_RECRUITMENT(normal_id, rc_num) values('hsj', 104);


select * from portfolio_recruitment;
---------------------------------------------------------------------

-- 고용형태종류와 PK 시퀀스
create table employment_type_category(
   emp_type_num number primary key,
   emp_type_name varchar2(100) not null
);

create sequence emp_type_num_seq start with 301;

insert into EMPLOYMENT_TYPE_CATEGORY(emp_type_num, emp_type_name) values(emp_type_num_seq.nextval, '인턴');
insert into EMPLOYMENT_TYPE_CATEGORY(emp_type_num, emp_type_name) values(emp_type_num_seq.nextval, '신입');
insert into EMPLOYMENT_TYPE_CATEGORY(emp_type_num, emp_type_name) values(emp_type_num_seq.nextval, '경력');
insert into EMPLOYMENT_TYPE_CATEGORY(emp_type_num, emp_type_name) values(emp_type_num_seq.nextval, '프리랜서');

select * from employment_type_category;
---------------------------------------------------------------------

-- 고용형태종류와 구인공고글 복합키 설정
create table job_emp(
   job_posting_num number,
   emp_type_num number,
   constraint fk_job_posting_num3 foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade,
   constraint fk_emp_job foreign key(emp_type_num) references employment_type_category(emp_type_num) on delete cascade,
   constraint pk_jobposting_jobemp primary key(emp_type_num,job_posting_num)
);

insert into JOB_EMP(job_posting_num, emp_type_num) values(1001, 302);
insert into JOB_EMP(job_posting_num, emp_type_num) values(1001, 304);
insert into JOB_EMP(job_posting_num, emp_type_num) values(1002, 304);

select * from job_emp;
---------------------------------------------------------------------

-- 고용형태종류와 구직회원 복합키 설정
create table portfolio_emp(
   normal_id varchar2(100),
   emp_type_num number,
   constraint fk_id_emp foreign key(normal_id) references portfolio(normal_id) on delete cascade,
   constraint fk_emp_pf foreign key(emp_type_num) references employment_type_category(emp_type_num) on delete cascade,
   constraint pk_id_emp_pf primary key(emp_type_num,normal_id)
);

insert into PORTFOLIO_EMP(normal_id, emp_type_num) values('yosep', 301);
insert into PORTFOLIO_EMP(normal_id, emp_type_num) values('yosep', 302);
insert into PORTFOLIO_EMP(normal_id, emp_type_num) values('yosep', 304);
insert into PORTFOLIO_EMP(normal_id, emp_type_num) values('MCW', 303);
insert into PORTFOLIO_EMP(normal_id, emp_type_num) values('MCW', 304);

select * from portfolio_emp;
---------------------------------------------------------------------

-- 지역분류와 PK 시퀀스
create table location_category(
   loc_num number primary key,
   loc_name varchar2(100) not null
);
create sequence loc_num_seq start with 501;

insert into location_category(loc_num, loc_name) values(loc_num_seq.nextval, '서울');
insert into location_category(loc_num, loc_name) values(loc_num_seq.nextval, '경기');
insert into location_category(loc_num, loc_name) values(loc_num_seq.nextval, '기타');

select * from location_category;
---------------------------------------------------------------------

-- 지역종류와 구인공고글 복합키 설정
create table job_loc(
   job_posting_num number,
   loc_num number,
   constraint fk_job_posting_num4 foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade,
   constraint fk_loc_job foreign key(loc_num) references location_category(loc_num) on delete cascade,
   constraint pk_jobposting_jobloc primary key(loc_num,job_posting_num)
);

insert into JOB_LOC(job_posting_num, loc_num) values(1003, 501);
insert into JOB_LOC(job_posting_num, loc_num) values(1002, 502);

select * from job_loc;
----------------------------------------------------------------------

--지역종류와 구직회원 복합키 설정
create table portfolio_loc(
   normal_id varchar2(100),
   loc_num number,
   constraint fk_id_loc foreign key(normal_id) references portfolio(normal_id) on delete cascade,
   constraint fk_loc_pf foreign key(loc_num) references location_category(loc_num) on delete cascade,
   constraint pk_id_loc_pf primary key(loc_num,normal_id)
);

insert into PORTFOLIO_LOC(normal_id, loc_num) values('yosep', 501);
insert into PORTFOLIO_LOC(normal_id, loc_num) values('yosep', 503);
insert into PORTFOLIO_LOC(normal_id, loc_num) values('MCW', 502);
insert into PORTFOLIO_LOC(normal_id, loc_num) values('MCW', 503);

select * from portfolio_loc;
-----------------------------------------------------------------------

-- 개발분야와 PK 시퀀스
create table development_category(
   dev_cat_num number primary key,
   rc_num number not null,
   dev_cat_name varchar2(100) not null,
   constraint fk_dev_num foreign key(rc_num) references recruitment_category(rc_num) on delete cascade
);

create sequence dev_cat_num_seq start with 201;

insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 101, 'Java');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 101, 'jsp');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 101, 'php');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 101, 'Ajax');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 101, '.NET');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 101, 'ASP');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, 'Java');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, 'C');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, 'C++');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, 'C#');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, '안드로이드');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, '아이폰');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, 'Linux');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, 'Python');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 102, '.NET');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 103, '임베디드');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 103, '펌웨어');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 103, 'PLC');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 104, '웹 퍼블리셔');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 104, 'HTML5');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 104, 'JavaScript');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 104, 'CSS3');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 104, 'UI/UX');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 105, '네트워크 관리');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 105, '서버 관리');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 105, '시스템 운영');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 106, 'DBA');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 106, 'SQL');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 107, '게임 개발');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 107, '게임 기획');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 107, '게임 디자인');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 107, '게임 운영');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 108, '빅데이터');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 108, '인공지능(AI)');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 108, '데이터 분석');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 108, '사물인터넷(IOT)');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 109, '시스템 설계');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 109, '시스템 분석');
insert into DEVELOPMENT_CATEGORY(dev_cat_num, rc_num, dev_cat_name) values(dev_cat_num_seq.nextval, 109, '시스템 엔지니어');

select * from development_category;
----------------------------------------------------------------------

-- 개발분야와 구인공고글 복합키 설정
create table job_dev(
   job_posting_num number,
   dev_cat_num number,
   constraint fk_job_posting_num5 foreign key (job_posting_num) references job_posting(job_posting_num) on delete cascade,
   constraint fk_dev_job foreign key(dev_cat_num) references development_category(dev_cat_num) on delete cascade,
   constraint pk_jobposting_jobdev primary key(dev_cat_num,job_posting_num)
);

insert into JOB_DEV(job_posting_num, dev_cat_num) values(1001, 201);
insert into JOB_DEV(job_posting_num, dev_cat_num) values(1001, 202);
insert into JOB_DEV(job_posting_num, dev_cat_num) values(1001, 204);
insert into JOB_DEV(job_posting_num, dev_cat_num) values(1001, 225);
insert into JOB_DEV(job_posting_num, dev_cat_num) values(1001, 226);
insert into JOB_DEV(job_posting_num, dev_cat_num) values(1002, 227);
insert into JOB_DEV(job_posting_num, dev_cat_num) values(1002, 228);

select * from job_dev;
----------------------------------------------------------------------

-- 개발분야와 구직회원 복합키 설정
create table portfolio_dev(
   normal_id varchar2(100),
   dev_cat_num number,
   constraint fk_id_dev foreign key(normal_id) references portfolio(normal_id) on delete cascade,
   constraint fk_dev_pf foreign key(dev_cat_num) references development_category(dev_cat_num) on delete cascade,
   constraint pk_id_dev_pf primary key(dev_cat_num,normal_id)
);

insert into PORTFOLIO_DEV(normal_id, dev_cat_num) values('yosep', 202);
insert into PORTFOLIO_DEV(normal_id, dev_cat_num) values('yosep', 203);
insert into PORTFOLIO_DEV(normal_id, dev_cat_num) values('yosep', 227);
insert into PORTFOLIO_DEV(normal_id, dev_cat_num) values('MCW', 201);
insert into PORTFOLIO_DEV(normal_id, dev_cat_num) values('MCW', 234);

select * from portfolio_dev;
----------------------------------------------------------------------

-- 학력구분과 PK 시퀀스
create table academic_category(
   academic_num number primary key,
   academic_name varchar2(100) not null
);
create sequence academic_num_seq start with 401;

insert into ACADEMIC_CATEGORY(academic_num, academic_name) values(academic_num_seq.nextval, '고졸');
insert into ACADEMIC_CATEGORY(academic_num, academic_name) values(academic_num_seq.nextval, '초대졸');
insert into ACADEMIC_CATEGORY(academic_num, academic_name) values(academic_num_seq.nextval, '대졸');
insert into ACADEMIC_CATEGORY(academic_num, academic_name) values(academic_num_seq.nextval, '석사졸업');
insert into ACADEMIC_CATEGORY(academic_num, academic_name) values(academic_num_seq.nextval, '박사졸업');

select * from academic_category;
----------------------------------------------------------------------

-- 학력구분과 구인공고글 복합키 설정
create table job_academic(
   job_posting_num number,
   academic_num number,
   constraint fk_job_posting_num6 foreign key(job_posting_num) references job_posting(job_posting_num) on delete cascade,
   constraint fk_academic_job foreign key(academic_num) references academic_category(academic_num) on delete cascade,
   constraint pk_jobposting_jobacademic primary key(academic_num,job_posting_num)
);

insert into JOB_ACADEMIC(job_posting_num, academic_num) values(1001, 402);
insert into JOB_ACADEMIC(job_posting_num, academic_num) values(1002, 403);

select * from job_academic;
----------------------------------------------------------------------

-- 학력구분과 구직회원 복합키 설정
create table portfolio_academic(
   normal_id varchar2(100),
   academic_num number,
   constraint fk_id_aca foreign key(normal_id) references portfolio(normal_id) on delete cascade,
   constraint fk_aca_pf foreign key(academic_num) references academic_category(academic_num) on delete cascade,
   constraint pk_id_aca_pf primary key(academic_num,normal_id)
);

insert into PORTFOLIO_ACADEMIC(normal_id, academic_num) values('yosep', 403);
insert into PORTFOLIO_ACADEMIC(normal_id, academic_num) values('MCW', 404);

select * from portfolio_academic;

commit


--SQL 테스트 

select normal_id
from( 
   select pd.normal_id, pd.dev_cat_num, pr.rc_num, pe.emp_type_num
   from portfolio_dev pd, portfolio_recruitment pr, portfolio_emp pe
   where pd.normal_id=pr.normal_id 
   and pr.normal_id=pe.normal_id 
)--분류 테이블 세 개를 동등 조인한 결과에서 검색 시작
where dev_cat_num =201 and rc_num =101 and emp_type_num =304 
-- 개발분야에서 java 선택  -- 모집직군에서 웹프로그래머선택 --고용형태에서 프리랜서 선택

select distinct normal_id  
from( 
   select pd.normal_id, pd.dev_cat_num, pr.rc_num, pe.emp_type_num
   from portfolio_dev pd, portfolio_recruitment pr, portfolio_emp pe
   where pd.normal_id=pr.normal_id 
   and pr.normal_id=pe.normal_id 
)--분류 테이블 세 개를 동등 조인한 결과에서 검색 시작
where dev_cat_num in (201,202) and rc_num in(101,106) and emp_type_num in (301,302) 
-- 개발분야에서 java, jsp 선택 
-- 모집직군에서 웹프로그래머, DBA/데이터베이스 선택 
-- 고용형태에서 인턴, 신입 선택

select job_posting_num
from( 
    select lc.loc_name,jl.loc_num,jl.job_posting_num
    from location_category lc , job_loc jl
    where jl.job_posting_num = lc.job_posting_num
    and 
)
where academic_num='401' 
delete table member 
--기업 전체보기 테스트 데이터
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser2', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser3', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser4', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser5', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser6', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser7', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);
insert into MEMBER(id, password, email, name, address, tel, member_type) values('Tmaxuser8', '123', 'Tmaxuser@tmax.com', 'TmaxSoft', '경기도 성남시 분당구 황새울로 258번길 29, BS타워 8-9층 티맥스소프트', '031-8018-1000', 3);

insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser2', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser3', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser4', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser5', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser6', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser7', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');
insert into COMPANY_MEMBER(company_id, introduction, company_type, industry, num_of_employees, picture_path) values('Tmaxuser8', '대한민국 S/W의 위상을 국내 및 전세계 시장에 알려나가고 있습니다.', '중견기업', 'SI/SM', 358, 'maeil.jpg');

-- 기업 전체 보기 rnum
select row_number() over(order by cm.company_id) as rnum, cm.company_id, m.name, cm.introduction
from member m , company_member cm
where m.id=cm.company_id

select company_id, name, introduction
from(
select row_number() over(order by cm.company_id) as rnum, 
	cm.company_id, m.name, cm.introduction
from member m , company_member cm
where m.id=cm.company_id
)  where rnum between 3 and 6

-- 채용정보 페이징처리
select 
	company_id, introduction, company_type, industry, sales, date_of_establishment, num_of_employees,
	job_posting_num, career_status,title,content,address,tel,email ,name 
from(
select row_number() over(order by j.job_posting_num) as rnum,
	cm.company_id, cm.introduction, cm.company_type, cm.industry, cm.sales, cm.date_of_establishment, cm.num_of_employees,
	j.job_posting_num, j.career_status, j.title, j.content, m.address, m.tel, m.email , m.name
	from job_posting j , company_member cm, member m
	where j.company_id = cm.company_id and cm.company_id=m.id
) where rnum between 1 and 3

-- 상세검색 페이징처리

select count(*)
from job_posting j , company_member cm, member m
where j.company_id = cm.company_id and cm.company_id=m.id and 
	j.job_posting_num in (1001,1002)

select 
	company_id, introduction, company_type, industry, sales, date_of_establishment, num_of_employees,
	job_posting_num, career_status, title, content, address, tel, email , name
	from
	 (select row_number() over(order by j.job_posting_num) as rnum, cm.company_id, cm.introduction, cm.company_type, cm.industry, cm.sales, cm.date_of_establishment, cm.num_of_employees,
	j.job_posting_num, j.career_status, j.title, j.content, m.address, m.tel, m.email , m.name
	from job_posting j , company_member cm, member m
	where j.company_id = cm.company_id and cm.company_id=m.id and 
	j.job_posting_num in 
	(1001,1002)
	)
	where rnum between 1 and 3

	
	
	


--기업 전체 보기 게시물 수
select count(*)
from member m , company_member cm
where m.id=cm.company_id


select job_posting_num
from( 
   select jd.job_posting_num, jd.dev_cat_num, jr.rc_num, je.emp_type_num, jl.loc_num, ja.academic_num
   from job_dev jd, job_recruitment jr, job_emp je, job_loc jl, job_academic ja
   where jd.job_posting_num=jr.job_posting_num 
   and jr.job_posting_num=je.job_posting_num 
   and je.job_posting_num=jl.job_posting_num
   and jl.job_posting_num=ja.job_posting_num
)
where dev_cat_num in() 
and rc_num in()  
and emp_type_num in() 
and loc_num in()
and academic_num in()
-- 개발분야에서 java 선택  -- 모집직군에서 웹프로그래머선택 --고용형태에서 프리랜서 선택




select job_posting_num
from( 
   select jd.job_posting_num, jd.dev_cat_num, jr.rc_num, je.emp_type_num
   from job_dev jd, job_recruitment jr, job_emp je
   where jd.job_posting_num=jr.job_posting_num 
   and jr.job_posting_num=je.job_posting_num 
   
)
where dev_cat_num in(201,227) 
and rc_num in(101,106)  
select title,content from job_posting
update job_posting set title='안녕쓰~' , content='하이룽쓰~' where job_posting_num='1001'
update job_academic set academic_num='401' where job_posting_num='1001'

-- 문자열이 포함된 타이틀로 검색하기
select job_posting_num,company_id,career_status,title,content
from job_posting where title like  '%'||#{keyword}||'%'
-- 문자열이 포함된 타이틀로 검색하기 페이징
select
		job_posting_num,company_id,career_status,title,content
from(
select row_number() over(order by job_posting_num) as rnum ,job_posting_num, company_id,career_status,title,content
from job_posting where title like '%Java%'
)
where rnum between 1 and 3


-- 키워드로 검색하기
select
		job_posting_num,title,company_id,career_status,content,keyword_name
from(
select row_number() over(order by k.job_posting_num) as rnum, k.job_posting_num ,j.title,j.company_id,j.career_status,j.content,k.keyword_name
from job_posting j, JOB_POSTING_KEYWORD k
where j.job_posting_num=k.job_posting_num
and k.keyword_name like '%워라밸%'
)
where rnum between 1 and 3


-- 키워드로 검색하기 페이징
select count(*)
from job_posting_keyword k , job_posting j
where k.job_posting_num = j.job_posting_num
and k.keyword_name like '%수평적문화%'

-- 기업 마이페이지 -> 면접신청자명단조회 시
-- 최신순으로 조회하기 위해 rnum 추가했고
-- 마지막 and 조건절을 넣지 않으면 Tmaxuser 와 NHNuser가 구분되지 않고 그냥 다 나와서 id조건을 주어야함	
select row_number() over(order by i.interview_num) as rnum ,
i.interview_num ,i.job_posting_num,i.title , nm.normal_id , cm.company_id , m.name
from interview i , normal_member nm , company_member cm ,member m
where i.normal_id = nm.normal_id and i.company_id = cm.company_id and i.normal_id = m.id
and cm.company_id='NHNuser' 
order by rnum desc

select qa.question, qa.answer, jm.name, jm.title, qa.normal_id, qa.job_posting_num
from (
select jp.job_posting_num, m.name, jp.title 
from job_posting jp, member m 
where jp.company_id=m.id
) jm, question_answer qa
where qa.job_posting_num = jm.job_posting_num
and qa.normal_id='qqqq'

