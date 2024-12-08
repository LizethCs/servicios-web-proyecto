import React, { useState, useEffect } from 'react';
import { CustomerUpdate } from './CustomerUpdate';
import { CustomerDelete } from './CustomerDelete';

export function CustomerList() {
  const [clientes, setClientes] = useState([]);
  const [clienteSeleccionado, setClienteSeleccionado] = useState(null);
  const credentials = "dXNlcjpwYXNzd29yZA==";

  useEffect(() => {
    const obtenerClientes = async () => {
      try {
        const headers = {
          "Authorization": `Basic ${credentials}`
        };
        const response = await fetch('http://localhost:8080/api/customers', {headers});
        const data = await response.json();
        setClientes(data);
      } catch (error) {
        console.error(error);
      }
    };
    obtenerClientes();
  }, []);

  const handleUpdate = (cliente) => {
    setClienteSeleccionado(cliente);
  };

  return (
    <div>
      <h1>Lista de clientes</h1>
      <ul>
        {clientes.map((cliente) => (
          <li key={cliente.id}>
            <h2>Nombre: {cliente.name}</h2>
            <p>Apellido: {cliente.lastName}</p>
            <p>Email: {cliente.email}</p>
            <p>Teléfono: {cliente.phone}</p>
            <button className="btn-edt" onClick={() => handleUpdate(cliente)}>Actualizar</button>
            <CustomerDelete cliente={cliente} />
          </li>
        ))}
      </ul>
      {clienteSeleccionado && (
        <CustomerUpdate cliente={clienteSeleccionado} />
      )}
    </div>
  );
}