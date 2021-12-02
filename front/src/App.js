import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router,
  Routes,
  Route} from 'react-router-dom';
import WebSocketPage from './Pages/ChattingPage';
import RoomPage from './Pages/RoomPage';
import MainPage from './Pages/MainPage';
import ChattingPage from './Pages/ChattingPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<MainPage/>} />
          <Route path="/room" element={<RoomPage />} />
          <Route path="/room/:roomId" element={<ChattingPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
