import React, { useState } from 'react'
import {HotelList} from './HotelList'
import {RoomList} from './RoomList'
import {CustomerList} from './CustomerList'
import {ReservationList} from './ReservationList'
import { HotelUpdateForm} from './HotelUpdateForm'


export const AdminPanel= () => {
  const [authenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    if (username === 'usuario' && password === '123') {
      setAuthenticated(true);
    } else {
      alert('Credenciales incorrectas');
    }
  };

  return (
    <div>
      {!authenticated ? (
        <div>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Usuario"
          />
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Contraseña"
          />
          <button onClick={handleLogin}>Iniciar sesión</button>
        </div>
      ) : (
        <>
        <HotelList /> 
        <RoomList/>
        <ReservationList/>
        <CustomerList></CustomerList>
        <HotelUpdateForm/>
        </>
      )}
    </div>
  );
}