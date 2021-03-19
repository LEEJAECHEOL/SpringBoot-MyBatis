#SpringBoot MyBatis 맛보기
###
https://mybatis.org/mybatis-3/ko/sqlmap-xml.html#select

### 의존성
- Spring Boot DevTools
- MySQL Driver
- Spring Web
- Lombok
- MyBatis

### DB 세팅

```sql
create user 'pos'@'%' identified by '1234';
GRANT ALL PRIVILEGES ON *.* TO 'pos'@'%';
create database pos;

```
```sql
create table product(
	id int auto_increment primary key,
    name varchar(50),
    code varchar(50)
);

create table panmae(
	id int auto_increment primary key,
    productId int,
    username varchar(50)
);
```

### 

dto를 db에서 다운받는법.
qlrm 라이브러리를 다운받아야함 Maven에서 다운받아서 폼에넣고 
=> 왜 쓰는가? 피벗을 다루는건 JPA에서 불가능하기 때문에. 


myBatis => 대한민국80%
앞으로 개발될 프로젝트는 마이바티스안씀. JPA 쓸꺼임

myBatis는 오브젝트를 매핑해주는 친구들임. 

myBatis는 설정할 수 있는 방법이 많음.
가장 쉬운방법은

myBatis는 

1. DB접근 기본 (DataSource)
jsp에서 PrepareStatement => rs => 오브젝트로 매핑 -> DB클로즈 하는 과정. => 귀찮음

2. JDBCTemplate
얘는 함수를 가지고 있음 (CRUD함수). 나왔을때 너무 좋았음. 위의 귀찮은 과정이 없어서.
다 알아서해줌. 근데 단점이 있음. Query가 자바코드로 들어감. 컴파일시에 확인이 불가능함.
쿼리가 자바코드로 들어가기때문에 변경시에 프로젝트 전체가 컴파일이 다시됨.

해결법 => 자바코드로 쿼리를 만들지말고 쿼리를 파일로 따로 뺌. => 파일을읽는건 컴파일이 아니라 런타임시에 실행됨. 

3. 위의 단점을 보완하가 위해 튀어나온게 iBatis 이게 이름이 바껴서 MyBatis
=> 쿼리를 xml에 집어넣고 자바에서는 xml파일을 읽는다.
=> 쿼리를 파일로 빼서 볼 수 있으니깐 자바코드가 더러워지지않음. 유지보수도 쉽고.

4. 스프링부트 => POJO (순수 자바로만 프로그램을 짜자. ) => XML을 버리기 시작.
=> xml을 버리기 시작하니깐 Hirebernate기술이 발전함 => JPA 탄생

마이바티스할때 주의할껀. xml에 mapper설정을 해줘야한다는것.

Repository를 사용하려는데 IoC에 등록되지않는다. @Repository 해도 올라가지않음. 이유는 interface이기때문이다.
그래서 어떤 특별한 어노테이션이 필요한데 @Mapper라는 어노테이션을 사용하면 굳이 Impl 이런식으로해서 구현체를 만들 필요가 없다.


1. 모델링 DB - table 생성
2. 프로젝트 구조
    config
    controller
    model
    repository
    service
    utils
3. mapper 파일 생성
4.  model 생성
5. repository 클래스 생성 (Mapper 설정)
6. config 파일 설정
7. 컨트롤러 구현하고
8. mapper 내부 구현


