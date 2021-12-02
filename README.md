# Spring-Boot-WebSocket-Stomp         

### 개발환경

- Spring Boot
- Gradle
- Mysql
- Stomp(WebSocket)

​                

### 구현요소

1. 여러 개의 채팅방을 개설할 수 있게 만들었습니다.
   - 채팅방을 만드는 사람의 이름을 지정할 수 있습니다.
   - 채팅방의 제목을 지정할 수 있습니다.
2. 채팅방에 접속할 수 있습니다.
   - 현재 입장 제한 인원은 존재하지 않습니다.
3. 접속한 채팅방에서 채팅을 진행할 수 있습니다.
   - 송신자의 이름을 지정할 수 있습니다.
   - 메세지의 내용을 지정할 수 있습니다.
   - 메세지의 내용은 단순 세로 정렬로 나타내었습니다.

​           

구현하는데 있어 Chat Entity, ChatRoom Entity를 구성하여 채팅방과 채팅내용을 DB에 저장하여 생성한 채팅방과 지금까지 전송한 메세지 내용을 저장하였습니다.

다시 입장할 시 지금까지 전송한 채팅창의 메세지 내용들을 확인할 수 있습니다.



<p align="center">
    <img src="https://github.com/SangHyunGil/Spring-Boot-WebSocket-Stomp/blob/main/img/chat.gif?raw=true">
</p>





