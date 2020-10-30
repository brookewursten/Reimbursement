$(document).ready(function () {
    $('#sortableTable').DataTable();
    $('.dataTables_length').addClass('bs-select');
});

var userRole
function getRole() {
    userRole = '<%=session.getAttribute("userRole")%>';
}

getRole();

function renderTable(reimbursments) {
    const authorResolver = document.getElementById("authorResolver")
    if (userRole === "MANAGER") {
        authorResolver.innerHTML = "Author";
    } else if (userRole === "EMPLOYEE") {
        authorResolver.innerHTML = "Resolver";
    } else throw new error();


    for (const r of reimbursements) {
        const tr = document.createElement("tr");
        const reimId = document.createElement("td");
        const amount = document.createElement("td");
        const submitted = document.createElement("td");
        const resolved = document.createElement("td");
        const description = document.createElement("td");
        const receipt = document.createElement("td");
        const name = document.createElement("td");
        const status = document.createElement("td");
        const type = document.createElement("td");
        reimId.innerText = r.reimId;
        amount.innerText = r.amount;
        submitted.innerText = monster.type.furry;
        resolved.innerText = monster.type.paws;
        description.innerText = r.description;
        receipt.innerText = r.receipt;
        if (type === "MANAGER") {
            name.innerText = r.authorName;
        } else if (type === "EMPLOYEE") {
            name.innerText = r.resolver;
        } else throw "err";
        status.innerText = r.status;
        type.innerText = r.type;


        tr.append(reimId, amount, submitted, resolved, description, receipt, name, status, type);
        document.getElementById("tableBody").append(tr);
    }
}

async function asyncFetch(url, expression) {
    const response = await fetch(url);
    const json = await response.json();
    expression(json);
}

try {
    

if (userRole == "MANAGER") {
    asyncFetch("http://localhost:8080/Reimbursement/all.json", renderTable);
} else if (userRole == "EMPLOYEE") {
    asyncFetch("http://localhost:8080/Reimbursement/mine.json")
} else throw "err";
} catch (err) {
    window.location.replace("../error.html");
}
