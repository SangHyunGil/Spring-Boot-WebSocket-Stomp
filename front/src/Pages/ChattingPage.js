import React, {useEffect, useState, useRef} from 'react'; 
import * as StompJs from "@stomp/stompjs";
import * as SockJS from "sockjs-client";
import WebSocketComp from '../Components/ChattingComp';
import { useParams } from "react-router-dom"
import { findAllChats } from '../Api/Api';

function ChattingPage () { 
    const client = useRef({});
    const params = useParams();
    const [contents, setContents] = useState([]);
    const [username, setUsername] = useState("");
    const [message, setMessage] = useState("");


    const sendMessage = (username, content) => {
        const newMessage = {
            "roomId" : params.roomId,
            "username" : username,
            "content" : content
        };
        if (!client.current.connected) {
            return;
          }
        
        console.log(newMessage);
        client.current.publish({
            destination: "/pub/chat/"+params.roomId,
            body: JSON.stringify(newMessage),
        });
      
        setMessage("");
    };

    const connect = () => {
        client.current = new StompJs.Client({
            webSocketFactory: () => new SockJS("/ws-stomp"), // proxy를 통한 접속
            debug: function (str) {
              console.log(str);
            },
            reconnectDelay: 5000,
            heartbeatIncoming: 4000,
            heartbeatOutgoing: 4000,
            onConnect: () => {
                findAllChats(params.roomId)
                    .then(response => response.data.data.map((message => {
                        setContents((prev) => [...prev, message]);
                    })))
                subscribe();
            },
            onStompError: (frame) => {
              console.error(frame);
            },
          });
      
          client.current.activate();
    };

    const subscribe = () => {
        client.current.subscribe(`/sub/`+params.roomId, ({ body }) => {
            setContents((prev) => [...prev, JSON.parse(body)]);
        });
    };

    const disconnect = () => {
        client.current.deactivate();
    };

    useEffect(() => {
        connect();
        
        return () => disconnect();
    }, [])

    return ( 
        <div> 
            <WebSocketComp contents={contents} username={username} message={message}
                           sendMessage={sendMessage} setUsername={setUsername} setMessage={setMessage} />
        </div> 
    ); } 
        
export default ChattingPage;