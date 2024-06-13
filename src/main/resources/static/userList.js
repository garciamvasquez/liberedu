// userList.js

// Selectores
const btnFindUser = document.getElementById('btnFindUser');
const btnAddUser = document.getElementById('btnAddUser');
const btnDeleteUser = document.getElementById('btnDeleteUser');
const tableUserList = document.getElementById('usersTable');
const addUserFormContainer = document.getElementById('add-user-form-container');
const deleteUserFormContainer = document.getElementById('delete-user-form-container');
const addUserForm = document.getElementById('add-user-form');
const deleteUserForm = document.getElementById('delete-user-form');

btnFindUser.addEventListener('click', (event) => {
  fetchUsers();
});

btnAddUser.addEventListener('click', (event) => {
  addUserFormContainer.style.display = 'block';
});

btnDeleteUser.addEventListener('click', (event) => {
  deleteUserFormContainer.style.display = 'block';
});

addUserForm.addEventListener('submit', (event) => {
  event.preventDefault();
  addUser();
});

deleteUserForm.addEventListener('submit', (event) => {
  event.preventDefault();
  deleteUser();
});

function fetchUsers() {
  fetch('/api/v1/users')
    .then(response => response.json())
    .then(users => renderUsers(users))
    .catch(error => console.error('Error al obtener los usuarios:', error));
}

function renderUsers(users) {
  const table = document.getElementById('usersTable');
  table.innerHTML = `
    <tr>
      <th>Usuario</th>
      <th>Rol</th>
      <th>Identificación</th>
      <th>Correo</th>
    </tr>
  `; // Resetea el contenido de la tabla
  users.forEach(user => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${user.firstname} ${user.lastname}</td>
      <td>${user.role.role}</td>
      <td>${user.idcard}</td>
      <td>${user.email}</td>
    `;
    table.appendChild(row);
  });
}

function addUser() {
  const user = {
    idcard: document.getElementById('idcard').value,
    firstname: document.getElementById('firstname').value,
    lastname: document.getElementById('lastname').value,
    email: document.getElementById('email').value,
    password: document.getElementById('password').value,
    roleId: document.getElementById('roleId').value
  };

  fetch('/api/v1/users', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Error en la creación del usuario');
    }
    return response.json();
  })
  .then(data => {
    alert('Usuario agregado con éxito');
    addUserFormContainer.style.display = 'none';
    fetchUsers(); // Actualiza la lista de usuarios
  })
  .catch(error => console.error('Error al agregar usuario:', error));
}

// ############### UPDATED ###############

function deleteUser() {
  const userId = document.getElementById('user-id').value;

  fetch(`/api/v1/users/${userId}`, {
    method: 'DELETE'
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Error al eliminar el usuario');
    }
    return response.json();
  })
  .then(data => {
    if (data) {
      alert('Usuario eliminado con éxito');
      deleteUserFormContainer.style.display = 'none';
      fetchUsers(); // Actualiza la lista de usuarios
    } else {
      alert('No se pudo eliminar el usuario');
    }
  })
  .catch(error => console.error('Error al eliminar usuario:', error));
}
// ############### UPDATED ###############