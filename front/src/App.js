import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router,
  Routes,
  Route} from 'react-router-dom';
import WebSocketPage from './Pages/WebSocketPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<WebSocketPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;