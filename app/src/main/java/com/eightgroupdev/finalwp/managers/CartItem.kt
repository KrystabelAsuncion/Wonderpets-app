data class CartItem(
    val productName: String?,
    val productPrice: Double,
    val productImageResource: Int,
    var quantity: Int // Quantity of this item in the cart
) {
    // Property to keep track of the total price for this item
    var totalPrice: Double = 0.0

    // Increment the quantity of this item in the cart
    fun incrementQuantity() {
        if (quantity > 0) {
            quantity++
            updateTotalPrice()
        }
    }

    // Decrement the quantity of this item in the cart
    fun decrementQuantity() {
        if (quantity > 0) {
            quantity--
            updateTotalPrice()
        }
    }

    // Update the total price based on the quantity
    private fun updateTotalPrice() {
        totalPrice = quantity * productPrice
    }
}
