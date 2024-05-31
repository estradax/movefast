function printInvoice() {
    var invoiceContent = document.getElementById('invoiceDetails').innerHTML;
    var originalContent = document.body.innerHTML;
    document.body.innerHTML = invoiceContent;
    window.print();
    document.body.innerHTML = originalContent;
}
