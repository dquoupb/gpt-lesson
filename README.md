# gpt-lession

자바, 스프링, 스프링부트, 스프링 배치, Redis, Kafka를 실무 관점에서 학습하고 직접 예제를 구현하는 백엔드 학습 저장소입니다.

모든 수업 진행은 chatGPT 선생님에 의해 진행되었습니다.

이 저장소는 단순 개념 정리가 아니라, 각 주차별 학습 내용을 직접 코드로 구현하고 실습하면서 백엔드 프레임워크와 실무 구조를 이해하는 것을 목표로 합니다.

---

## 학습 목표

- Java 기반 백엔드 개발의 핵심 개념 이해
- Spring Framework의 IoC, DI, Bean, ApplicationContext 구조 이해
- Spring Boot AutoConfiguration 구조 이해
- 인터페이스 기반 설계와 확장 가능한 구조 설계 연습
- Spring Batch 기반 배치 처리 구조 이해
- Redis, Kafka를 활용한 실무 백엔드 아키텍처 학습
- 단순 사용자가 아닌 프레임워크 개발자 관점에서 구조를 이해하고 구현하기

---

## 전체 커리큘럼

| 주차 | 주제 | 목표 |
|---|---|---|
| 1주차 | Spring 핵심 기초 | Spring이 왜 필요한지, Bean이 어떻게 생성·주입·관리되는지 이해 |
| 2주차 | Spring Boot 구조와 AutoConfiguration | 자동 설정, 조건부 Bean 등록, 커스텀 Starter 구조 이해 |
| 3주차 | 실무형 설계 패턴 | 인터페이스 기반 설계, Factory, Registry, Strategy 패턴 이해 |
| 4주차 | Spring Batch 기초 | Job, Step, Reader, Processor, Writer 구조 이해 |
| 5주차 | Spring Batch 실무 확장 | 커스텀 Reader/Writer, Listener, ExecutionContext, 예외 처리 이해 |
| 6주차 | Redis / Kafka 실무 연동 | 캐시, 메시징, 이벤트 기반 구조, 실무 통합 예제 구현 |

---

# 1주차: Spring 핵심 기초

목표는 “Spring이 왜 필요한지”와 “Bean이 어떻게 생성·주입·관리되는지”를 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 1일차 | Spring이 필요한 이유, Framework vs Library, Spring 생태계 | 순수 Java 코드와 Spring 코드 비교 | 완료 |
| 2일차 | IoC / DI, 생성자 주입, 필드 주입, Setter 주입 | 의존성 주입 방식별 예제 구현 | 완료 |
| 3일차 | 의존성 역전 원칙, 인터페이스 기반 설계 | 인터페이스와 구현체 분리 예제 | 완료 |
| 4일차 | Bean 개념, Bean 등록 방식, Component Scan | `@Component`, `@Bean`, `@Configuration` 예제 | 진행 중 |
| 5일차 | `@Primary`, `@Qualifier`, Bean 중복 문제 | 동일 타입 Bean 여러 개 등록 후 주입 제어 | 예정 |
| 6일차 | ApplicationContext, BeanFactory 차이, Bean 조회 | ApplicationContext에서 Bean 직접 조회 | 예정 |
| 7일차 | 1주차 복습 및 미니 프로젝트 | ObjectStorageClient 구조 미니 구현 | 예정 |

---

# 2주차: Spring Boot 구조와 AutoConfiguration

목표는 Spring Boot가 내부적으로 Bean을 자동 등록하고 설정하는 방식을 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 8일차 | Spring Boot가 등장한 이유 | Spring vs Spring Boot 설정 비교 | 예정 |
| 9일차 | AutoConfiguration 개념 | 직접 AutoConfiguration 클래스 작성 | 예정 |
| 10일차 | `@ConditionalOnProperty` | 설정값에 따라 Bean 등록 제어 | 예정 |
| 11일차 | `@ConditionalOnMissingBean` | 사용자가 Bean을 등록하면 기본 Bean 대체 | 예정 |
| 12일차 | Configuration Properties | `application.yml` 값을 객체로 바인딩 | 예정 |
| 13일차 | Custom Starter 구조 | 간단한 Starter 모듈 구조 설계 | 예정 |
| 14일차 | 2주차 복습 및 미니 프로젝트 | ObjectStorage AutoConfiguration 구현 | 예정 |

---

# 3주차: 실무형 설계 패턴

목표는 실무 백엔드 프레임워크에서 자주 사용되는 구조를 직접 구현하며 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 15일차 | Strategy Pattern | 타입별 처리 전략 분리 | 예정 |
| 16일차 | Factory Pattern | 조건에 맞는 객체 생성 구조 구현 | 예정 |
| 17일차 | Registry Pattern | 여러 구현체를 Map으로 관리 | 예정 |
| 18일차 | Template Method Pattern | 공통 흐름과 세부 구현 분리 | 예정 |
| 19일차 | Adapter Pattern | 외부 라이브러리 구조 감싸기 | 예정 |
| 20일차 | 실무 구조 조합 | Factory + Registry + Strategy 조합 | 예정 |
| 21일차 | 3주차 복습 및 미니 프로젝트 | 파일 처리 프레임워크 구조 구현 | 예정 |

---

# 4주차: Spring Batch 기초

목표는 Spring Batch의 기본 구성 요소와 Chunk 기반 처리 흐름을 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 22일차 | Spring Batch 개요 | Job, Step 기본 구조 구현 | 예정 |
| 23일차 | Tasklet Step | 단일 작업 Step 구현 | 예정 |
| 24일차 | Chunk 기반 처리 | Reader, Processor, Writer 구현 | 예정 |
| 25일차 | JobParameter | 실행 파라미터 전달 및 조회 | 예정 |
| 26일차 | StepScope / JobScope | 실행 시점 Bean 생성 구조 이해 | 예정 |
| 27일차 | FlatFileItemReader / Writer | 파일 읽기 및 쓰기 예제 | 예정 |
| 28일차 | 4주차 복습 및 미니 프로젝트 | CSV 파일 읽기 → 가공 → 파일 출력 | 예정 |

---

# 5주차: Spring Batch 실무 확장

목표는 실무에서 자주 사용하는 Batch 확장 구조와 예외 처리 방식을 이해하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 29일차 | ExecutionContext | Step 간 데이터 공유 | 예정 |
| 30일차 | Listener | JobExecutionListener, StepExecutionListener 구현 | 예정 |
| 31일차 | CompositeItemWriter | 여러 Writer 조합 구조 구현 | 예정 |
| 32일차 | ClassifierCompositeItemWriter | 조건에 따라 Writer 분기 | 예정 |
| 33일차 | 예외 처리 | Skip, Retry, Rollback 구조 이해 | 예정 |
| 34일차 | Partitioning | 대용량 데이터 병렬 처리 구조 이해 | 예정 |
| 35일차 | 5주차 복습 및 미니 프로젝트 | 조건별 파일 분리 배치 구현 | 예정 |

---

# 6주차: Redis / Kafka 실무 연동

목표는 Redis와 Kafka를 Spring Boot 애플리케이션에 연동하고 실무형 구조로 활용하는 것입니다.

| 일차 | 학습 내용 | 실습 주제 | 상태 |
|---|---|---|---|
| 36일차 | Redis 개요 | Redis 기본 자료구조 실습 | 예정 |
| 37일차 | Spring Boot Redis 연동 | RedisTemplate 사용 예제 | 예정 |
| 38일차 | Cache 구조 | `@Cacheable`, `@CacheEvict` 실습 | 예정 |
| 39일차 | Kafka 개요 | Topic, Producer, Consumer 개념 이해 | 예정 |
| 40일차 | Spring Boot Kafka Producer | 이벤트 발행 구조 구현 | 예정 |
| 41일차 | Spring Boot Kafka Consumer | 이벤트 구독 및 처리 구조 구현 | 예정 |
| 42일차 | 최종 미니 프로젝트 | Batch + Redis + Kafka 통합 예제 구현 | 예정 |

---

## 실습 진행 방식

각 일차별로 다음 순서로 학습합니다.

1. 개념 정리
2. 핵심 코드 예제 작성
3. 실무에서 사용하는 구조로 확장
4. 직접 코드 작성
5. GitHub에 커밋
6. README 또는 학습 노트 정리

---

## 디렉터리 구조 예시

```text
gpt-lesson
└── src/main/java/gpt/lesson/chatgptlesson
    ├── springcore
    │   ├── ioc
    │   ├── di
    │   └── bean
    │
    ├── objectstorage
    │   ├── client
    │   ├── registry
    │   ├── config
    │   └── service
    │
    ├── autoconfiguration
    │   ├── condition
    │   ├── properties
    │   └── storage
    │
    ├── batch
    │   ├── tasklet
    │   ├── chunk
    │   ├── reader
    │   ├── processor
    │   ├── writer
    │   └── listener
    │
    ├── redis
    │   ├── basic
    │   └── cache
    │
    └── kafka
        ├── producer
        ├── consumer
        └── event
