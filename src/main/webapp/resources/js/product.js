// Delete Item
const buttonDelete = document.querySelectorAll("[button-delete]");
if (buttonDelete.length > 0) {
    const formDeleteItem = document.querySelector("#form-delete-product");
    const path = formDeleteItem.getAttribute("data-path");

    buttonDelete.forEach(button => {
        button.addEventListener("click", () => {
            const isConfirm = confirm("Xóa sản phẩm này!");
            if (isConfirm) {
                const id = button.getAttribute("data-id");
                formDeleteItem.action = path + `${id}`;

                formDeleteItem.submit();
            }
        });
    });
}
// End Delete Item