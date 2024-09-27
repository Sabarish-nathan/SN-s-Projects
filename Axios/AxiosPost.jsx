import React, { useEffect, useState } from 'react';
import Axios from 'axios';
const CreateAxi = () => {
    const [users, setUsers] = useState([]);
    const [newUser, setNewUser] = useState({ name: '', email: '' });

    useEffect(() => {
        Axios.get("https://jsonplaceholder.typicode.com/users")
            .then(res => setUsers(res.data))
    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();
        Axios.post("https://jsonplaceholder.typicode.com/users", newUser)
            .then(response => {
                setUsers([...users, response.data]);
                setNewUser({ name: '', email: '' });
            })
            .catch(error => console.error(error));
    };

    const handleInputChange = (event) => {
        setNewUser({ ...newUser, [event.target.name]: event.target.value });
    };

    return (
        <>
            <h1>Create User with Axios</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Name:
                    <input type="text" name="name" value={newUser.name} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Email:
                    <input type="email" name="email" value={newUser.email} onChange={handleInputChange} />
                </label>
                <br />
                <button type="submit">Create User</button>
            </form>
            <table border="2px">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user) =>
                        <tr key={user.id}>
                            <td>{user.name}</td>
                            <td>{user.email}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </>
    )
}
export default CreateAxi;