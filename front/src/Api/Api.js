import axios from "axios";

export const findAllRooms = async () => {
    return await axios.get("/room");
}

export const createRoom = async (roomName, personName) => {
    return await axios.post("/room", {
        roomName : roomName,
        personName : personName
    })
}

export const findAllChats = async (roomId) => {
    return await axios.get("/room/"+roomId);
}