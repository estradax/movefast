function goBack() {
    window.location.href = 'index.html';
}

document.getElementById('updateForm').addEventListener('submit', function(event) {
    event.preventDefault();
    // Simulate update process
    alert('Data successfully updated!');
});
