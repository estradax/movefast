document.getElementById('reservation-form').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    console.log('Form Data Submitted:', data);

    // Display success message
    const successMessage = document.getElementById('success-message');
    successMessage.style.display = 'block';

    // Generate QR Code
    const qrCodeContainer = document.getElementById('qr-code');
    const qrCodeImg = document.getElementById('qr-code-img');
    const paymentInfo = JSON.stringify(data);
    const qrCodeURL = `https://chart.googleapis.com/chart?cht=qr&chs=300x300&chl=${encodeURIComponent(paymentInfo)}`;

    qrCodeImg.src = qrCodeURL;
    qrCodeContainer.style.display = 'block';

    setTimeout(() => {
        successMessage.style.display = 'none';
    }, 3000);

    event.target.reset();
});
