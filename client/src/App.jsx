import "./styles/styles.css"
import { Home } from "./views/Home"
import { Reservar } from "./views/Reservar"
import { AdminPanel } from "./views/AdminPanel"
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ReservasCliente from "./views/ReservasCliente";

function App() {
  return (
    <BrowserRouter>
    <Routes>
        <Route path="/home" element={<Home/>} />
        <Route path="reservar" element={<Reservar />} />
        <Route path="admin" element={<AdminPanel/>}/>
        <Route path="reservas" element={<ReservasCliente/>}/>
    </Routes>
    </BrowserRouter>
  )
}
export default App;