# gpt-lesson

자바, 스프링, 스프링부트, 스프링 배치, Redis, Kafka를 실무 관점에서 학습하고 직접 예제를 구현하는 백엔드 학습 저장소입니다.

이 저장소는 단순 개념 정리가 아니라, 각 일차별 학습 내용을 직접 코드로 구현하고 GitHub에 커밋하면서 백엔드 프레임워크와 실무 구조를 이해하는 것을 목표로 합니다.

모든 수업은 ChatGPT와 함께 진행하며, 개념 학습 → 예제 구현 → 실무 구조 확장 → GitHub 커밋 → README 정리 순서로 진행합니다.

---

## 학습 목표

- Java 기반 백엔드 개발의 핵심 개념 이해
- Spring Framework의 IoC, DI, Bean, ApplicationContext 구조 이해
- Spring Boot의 설정 관리와 Auto Configuration 구조 이해
- Spring MVC 기반 웹 요청 흐름 이해
- DTO, Validation, Exception 처리 구조 설계
- JDBC, DataSource, MyBatis 기반 데이터 접근 구조 이해
- Spring Transaction, AOP, Security 구조 이해
- Spring Batch 기반 대용량 배치 처리 구조 이해
- Redis, Kafka를 활용한 캐시 및 메시징 구조 이해
- 테스트, 로깅, 모니터링, 운영 지식 학습
- 단순 사용자 관점이 아니라 프레임워크 개발자 관점에서 구조를 이해하고 구현하기

---

## 전체 커리큘럼 v2

| 주차 | 주제 | 목표 |
|---|---|---|
| 1주차 | Spring 핵심 기초 | IoC, DI, Bean, ApplicationContext, Scope 이해 |
| 2주차 | Spring Boot와 설정 구조 | starter, application.yml, ConfigurationProperties, AutoConfiguration 이해 |
| 3주차 | Spring MVC / DTO / Validation / Exception | 웹 요청 흐름, Controller, DTO 설계, 검증, 예외 처리 이해 |
| 4주차 | DB 접근 / Transaction / AOP | JDBC, DataSource, MyBatis, 트랜잭션, AOP 구조 이해 |
| 5주차 | Security / Async / Event / Test | 인증·인가, 비동기, 이벤트, 테스트 구조 이해 |
| 6주차 | Spring Batch 기본 | Job, Step, Tasklet, Chunk, Reader, Processor, Writer 이해 |
| 7주차 | Spring Batch 실무 확장 / Redis | ExecutionContext, Listener, Skip/Retry, Partitioning, Redis Cache 이해 |
| 8주차 | External API / Kafka / 운영 / 아키텍처 | 외부 연동, Kafka, 로깅, 모니터링, 아키텍처 기본 이해 |

---

# 1주차: Spring 핵심 기초

목표는 Spring이 왜 필요한지 이해하고, Bean이 어떻게 생성·주입·관리되는지 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 1일차 | Spring이 필요한 이유, Framework vs Library, Spring 생태계 | 순수 Java 코드와 Spring 코드 비교 | 완료 |
| 2일차 | IoC / DI, 생성자 주입, 필드 주입, Setter 주입 | 의존성 주입 방식별 예제 구현 | 완료 |
| 3일차 | 의존성 역전 원칙, 인터페이스 기반 설계 | 인터페이스와 구현체 분리 예제 구현 | 완료 |
| 4일차 | Bean 개념, Bean 등록 방식, Component Scan | `@Component`, `@Bean`, `@Configuration` 예제 구현 | 완료 |
| 5일차 | `@Primary`, `@Qualifier`, Bean 중복 문제 | 동일 타입 Bean 여러 개 등록 후 주입 제어 | 완료 |
| 6일차 | ApplicationContext, BeanFactory 차이, Bean 조회 | ApplicationContext에서 Bean 직접 조회 | 완료 |
| 7일차 | Bean 생명주기, Scope, ObjectProvider, Provider | singleton/prototype 문제와 지연 조회 예제 구현 | 완료 |

---

# 2주차: Spring Boot와 설정 구조

목표는 Spring Boot가 해결하는 문제와 자동 설정, 조건부 Bean 등록, 설정값 바인딩 구조를 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 8일차 | Spring Boot가 해결하는 문제, starter, 내장 톰캣 | Spring Boot 기본 실행 구조 확인 | 완료 |
| 9일차 | 프로젝트 구조: controller/service/repository/domain/dto/config | 계층형 패키지 구조 설계 | 완료 |
| 10일차 | `application.yml`, profile, 환경 변수, `@Value` | profile별 설정값 분리 | 완료 |
| 11일차 | Auto Configuration 원리, `@Conditional` 계열 | 조건에 따라 Bean 등록 제어 | 완료 |
| 12일차 | `@ConfigurationProperties` | `application.yml` 값을 객체로 바인딩 | 예정 |
| 13일차 | `@ConditionalOnProperty`, `@ConditionalOnBean`, `@ConditionalOnMissingBean` 심화 | 설정값과 사용자 Bean에 따른 자동 설정 제어 | 예정 |
| 14일차 | 2주차 미니 프로젝트 | Notification AutoConfiguration 구현 | 예정 |

---

# 3주차: Spring MVC / DTO / Validation / Exception

목표는 웹 요청이 Controller까지 들어오고, Service/Repository를 거쳐 응답으로 반환되는 전체 흐름을 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 15일차 | MVC 요청 흐름, DispatcherServlet, HandlerMapping | 요청 흐름 그림과 간단한 API 구현 | 예정 |
| 16일차 | Controller, `@RestController`, Mapping 어노테이션 | GET/POST/PUT/DELETE API 구현 | 예정 |
| 17일차 | 요청 값 받기 | `@RequestParam`, `@PathVariable`, `@RequestBody`, `@ModelAttribute` 실습 | 예정 |
| 18일차 | 응답 처리 | DTO 응답, ResponseEntity, HTTP Status 처리 | 예정 |
| 19일차 | DTO 설계 | Request DTO, Response DTO, Entity 분리 구조 구현 | 예정 |
| 20일차 | Validation | `@Valid`, `@Validated`, 검증 실패 응답 처리 | 예정 |
| 21일차 | 전역 예외 처리 | `@RestControllerAdvice`, `@ExceptionHandler`, BusinessException 구현 | 예정 |

---

# 4주차: DB 접근 / Transaction / AOP

목표는 애플리케이션이 DB에 접근하는 구조와 트랜잭션이 적용되는 방식을 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 22일차 | JDBC 기본 | Connection, PreparedStatement, ResultSet 흐름 이해 | 예정 |
| 23일차 | DataSource, HikariCP | 커넥션 풀 설정과 동작 확인 | 예정 |
| 24일차 | MyBatis 기본 | Mapper Interface, Mapper XML 구현 | 예정 |
| 25일차 | MyBatis 동적 SQL | `<if>`, `<choose>`, `<foreach>` 실습 | 예정 |
| 26일차 | 트랜잭션 기본 | commit, rollback, auto commit 실습 | 예정 |
| 27일차 | Spring Transaction | `@Transactional`, 프록시, self-invocation 문제 실습 | 예정 |
| 28일차 | AOP 기본 | 실행 시간 측정 AOP, 로깅 AOP 구현 | 예정 |

---

# 5주차: Security / Async / Event / Test

목표는 인증·인가, 비동기 처리, 이벤트 처리, 테스트 구조를 실무 관점에서 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 29일차 | Spring Security 기본 | 인증, 인가, SecurityContext 구조 이해 | 예정 |
| 30일차 | SecurityFilterChain | URL 권한 제어 실습 | 예정 |
| 31일차 | Session Login / JWT Login 개념 | 로그인 방식 비교 및 구조 설계 | 예정 |
| 32일차 | CORS, CSRF, PasswordEncoder | 보안 기본 설정 실습 | 예정 |
| 33일차 | 비동기 처리 | `@Async`, ThreadPoolTaskExecutor 구현 | 예정 |
| 34일차 | 이벤트 처리 | ApplicationEventPublisher, `@TransactionalEventListener` 구현 | 예정 |
| 35일차 | 테스트 기본 | JUnit, AssertJ, Mockito, `@SpringBootTest` 실습 | 예정 |

---

# 6주차: Spring Batch 기본

목표는 Spring Batch의 기본 구성 요소와 Chunk 기반 처리 흐름을 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 36일차 | Spring Batch 개요 | Job, Step, JobRepository, JobLauncher 구조 이해 | 예정 |
| 37일차 | JobExecution, StepExecution, JobParameter | 실행 메타데이터 확인 실습 | 예정 |
| 38일차 | Tasklet Step | 단일 작업 Step 구현 | 예정 |
| 39일차 | Chunk 기반 처리 | Reader, Processor, Writer 흐름 구현 | 예정 |
| 40일차 | ItemReader, ItemProcessor, ItemWriter | 직접 커스텀 Reader/Processor/Writer 구현 | 예정 |
| 41일차 | DB Reader | JdbcCursorItemReader, JdbcPagingItemReader 실습 | 예정 |
| 42일차 | File Reader / Writer | CSV 파일 읽기 → 가공 → 파일 출력 | 예정 |

---

# 7주차: Spring Batch 실무 확장 / Redis

목표는 실무에서 자주 사용하는 Batch 확장 구조와 Redis Cache 구조를 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 43일차 | ExecutionContext | Step 간 데이터 공유 실습 | 예정 |
| 44일차 | Listener | JobExecutionListener, StepExecutionListener 구현 | 예정 |
| 45일차 | Skip / Retry / noRollback | 예외 발생 시 Skip, Retry 처리 실습 | 예정 |
| 46일차 | CompositeItemWriter | 여러 Writer 조합 구조 구현 | 예정 |
| 47일차 | Partitioning / Multi-thread Step | 대용량 데이터 병렬 처리 구조 이해 | 예정 |
| 48일차 | Redis 기본 | RedisTemplate, StringRedisTemplate 사용 | 예정 |
| 49일차 | Spring Cache | `@Cacheable`, `@CachePut`, `@CacheEvict`, TTL 실습 | 예정 |

---

# 8주차: External API / Kafka / 운영 / 아키텍처

목표는 외부 시스템 연동, Kafka 메시징, 운영 지식, 아키텍처 기본 개념을 실무 관점에서 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 50일차 | RestTemplate, WebClient, Feign Client | 외부 API 호출 구조 구현 | 예정 |
| 51일차 | Timeout, Retry, Circuit Breaker, Idempotency | 외부 연동 장애 대응 구조 설계 | 예정 |
| 52일차 | Kafka 기본 | topic, partition, offset, consumer group 이해 | 예정 |
| 53일차 | Kafka Producer | 이벤트 발행 구조 구현 | 예정 |
| 54일차 | Kafka Consumer | 이벤트 구독 및 처리 구조 구현 | 예정 |
| 55일차 | 운영 지식 | Logging, Actuator, Health Check, Metrics 실습 | 예정 |
| 56일차 | 아키텍처 정리 | Layered, Hexagonal, DDD, MSA 개요 정리 | 예정 |

---

## 실습 진행 방식

각 일차별 수업은 다음 순서로 진행합니다.

1. 개념 정리
2. 핵심 코드 예제 작성
3. 실무에서 사용하는 구조로 확장
4. 직접 코드 작성
5. GitHub에 커밋
6. README 또는 학습 노트 정리

---

## Git 커밋 규칙

커밋 메시지는 다음 형식을 사용합니다.

```text
day01: Spring이 필요한 이유 실습
day02: IoC DI 예제 구현
day03: DIP와 인터페이스 기반 설계 실습
day11: AutoConfiguration 조건부 Bean 등록 실습
day15: MVC 요청 흐름과 Controller 구현
day36: Spring Batch Job Step 기본 구조 구현