export function CustomerDelete({ cliente }) {
  const handleDelete = async () => {
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
      };
      const response = await fetch(`http://localhost:8080/api/customers/${cliente.id}`, {
        method: "DELETE",
        headers,
      });
      if (response.ok) {
        alert("Cliente eliminado con éxito");
      } else {
        alert("Error al eliminar el cliente");
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <button className="btn-edt" onClick={handleDelete}>Eliminar cliente</button>
    </div>
  );
}