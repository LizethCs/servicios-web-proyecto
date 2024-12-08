export function RoomDelete({ habitacion }) {
  const handleDelete = async () => {
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
      };
      const response = await fetch(`http://localhost:8080/api/rooms/${habitacion.id}`, {
        method: "DELETE",
        headers,
      });
      if (response.ok) {
        alert("Habitación eliminada con éxito");
      } else {
        alert("Error al eliminar la habitación");
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <button className="btn-edt" onClick={handleDelete}>Eliminar habitación</button>
    </div>
  );
}