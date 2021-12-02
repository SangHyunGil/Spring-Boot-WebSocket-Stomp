import React, { useEffect, useState } from "react";
import useInput from "../hook/useInput";
import { findAllRooms, createRoom } from "../Api/Api";
import { Link } from "react-router-dom";
import "./RoomStyles.css"

const RoomComp = () => {
    const [rooms, setRooms] = useState([]);
    const [username, onChangeUsername] = useInput("");
    const [roomname, onChangeRoomname] = useInput("");

    const onCreateRoom = (e) => {
        e.preventDefault();
        createRoom(roomname, username)
            .then(response => setRooms((prev) => [...prev, response.data.data]))
            .catch(error => console.log(error));
    }

    useEffect(() => {
        findAllRooms()
            .then(response => response.data.data.map((room) => (
                setRooms((prev) => [...prev, room]))
            ))
            .catch(error => console.log(error));
        
    }, [])


    return (
        <div>
            <form onSubmit={onCreateRoom}>
                <label htmlFor="username">방 개설자</label>
                <input id="username" value={username} onChange={onChangeUsername}></input> <b />
                <label htmlFor="roomname">방 이름</label>
                <input id="roomname" value={roomname} onChange={onChangeRoomname}></input> <b />
                <button type="submit">개설</button>
                <div className="rm">
                    {rooms.map((room, idx) => (
                        <Link to = {{pathname:`/room/${room.roomId}`}} key={idx}>제목 {room.roomName} - 방장 {room.personName} </Link>
                    ))} 
                    <br />
                </div>
            </form>
        </div>
    )
}

export default RoomComp