object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    // Add an item to the cart
    fun addToCart(item: CartItem) {
        cartItems.add(item)
    }

    // Remove an item from the cart
    fun removeFromCart(item: CartItem) {
        cartItems.remove(item)
    }

    // Clear the entire cart
    fun clearCart() {
        cartItems.clear()
    }

    // Retrieve a copy of the cart items
    fun getCartItems(): List<CartItem> {
        return cartItems.toList()
    }

    // Get the total number of items in the cart
    fun getTotalItemsInCart(): Int {
        return cartItems.size
    }

    // Calculate the total price of items in the cart
    fun getTotalCartPrice(): Double {
        var total = 0.0
        for (item in cartItems) {
            total += item.productPrice * item.quantity
        }
        return total
    }
}
