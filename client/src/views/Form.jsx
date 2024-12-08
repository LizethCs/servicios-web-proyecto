import React, { useState } from 'react';
import {Reservar} from "./Reservar.jsx"
export function Form() {
  const [authenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    if (username === 'usuario' && password === 'contraseña') {
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
        <div>
          <h1>Bienvenido!</h1>
          <Reservar />
        </div>
      )}
    </div>
  );
}


