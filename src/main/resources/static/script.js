const API_URL = "http://localhost:8082/employees"; // Update this if your backend runs on a different port

// Load employees when page loads
window.onload = fetchEmployees;

// Fetch all employees
function fetchEmployees() {
    fetch(API_URL)
        .then(res => {
            if (!res.ok) throw new Error("Failed to fetch employees");
            return res.json();
        })
        .then(data => {
            const table = document.getElementById("employeeTable");
            table.innerHTML = "";

            data.forEach(emp => {
                table.innerHTML += `
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.phone}</td>
                        <td>${emp.email}</td>
                        <td>
                            <button class="action-btn btn btn-primary" onclick="deleteEmployee(${emp.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;
            });
        })
        .catch(err => {
            alert("Error loading employees ❌");
            console.error(err);
        });
}

// Add new employee
function addEmployee() {
    const name = document.getElementById("name").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const email = document.getElementById("email").value.trim();

    // Basic validation
    if (!name || !phone || !email) {
        alert("Please fill all fields ⚠️");
        return;
    }

    const employee = { name, phone, email };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
        .then(res => {
            if (!res.ok) throw new Error("Failed to add employee");
            return res.json();
        })
        .then(() => {
            fetchEmployees();
            document.getElementById("name").value = "";
            document.getElementById("phone").value = "";
            document.getElementById("email").value = "";
            alert("Employee added successfully ✅");
        })
        .catch(err => {
            alert("Error adding employee ❌");
            console.error(err);
        });
}

// Delete employee
function deleteEmployee(id) {
    const confirmDelete = confirm("Are you sure you want to delete this employee?");
    if (!confirmDelete) return;

    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
        .then(res => {
            if (!res.ok) throw new Error("Delete failed");
            fetchEmployees();
        })
        .catch(err => {
            alert("Error deleting employee ❌");
            console.error(err);
        });
}
