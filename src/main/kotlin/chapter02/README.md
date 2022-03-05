## Chapter2 - 코틀린 기초
#### 정리
* 함수
  * p62~63 - 함수 선언
    * 블록이 본문인 함수
    * 식이 본문인 함수
* 변수
  ```kotlin
  val question = "삶, 우주, 그릭고 모든 것에 대한 궁극적인 질문"
  val answer = 42
  val answer: Int = 42
  ```
  * p65 - 초기화 식이 없다면 변수에 저장될 값에 대해 아무 정보가 없기 때문에 컴파일러가 타입을 추론할 수 없다.  
  따라서 그런 경우 타입을 반드신 지정해야 한다.
    ```kotlin
    val answer: Int
    answer = 42
    ```
  * p65 - 변경 가능 변수, 변경 불가능 변수
    * val - 변경 불가능한 변수. java의 final 변수에 해당
    * var - 변경 가능한 변수
    * 기본적으로 모든 변수를 val 키워드를 사용해 불변 변수로 선언하고, 꼭 필요할 때에만 var로 변경하라  
* 프로퍼티
  * p71 - 자바에서는 필드와 접근자를 한데 묶어 프로퍼티라고 부른다.  
    코틀린은 프로퍼티를 언어 기본 기능으로 제공하며, 코틀린 프로퍼티는 자바의 필드와 접근자 메소드를 완전히 대신한다.
    ```kotlin
    class Person(
      val name: String,
      var isMarried: Boolean
    )
    
    val person = Person("leaf", false)
    println(person.name)
    println(person.isMarried)
    ```
    getter를 호출하는 대신 프로퍼티를 직접 사용했음에 유의. 로직은 동일하지만 코드는 더 간결해짐
  * p73 - 커스텀 접근자
