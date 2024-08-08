package com.chronelab.basic.model

class CategoryHandler {
    companion object {
        var catgories: MutableList<Category> = mutableListOf(Category(1,"Fruits"), Category(2,"Vegetables") )

        public fun addCategory(category: Category) {
            catgories.add(category)
        }

        public fun  removeCategory(category: Category) {
            catgories.removeAll {it.id == category.id }
        }

        public fun updateCategory(category: Category) {
            val existingCategory = catgories.find { it.id ==  category.id}
            existingCategory?.let {
                it.name = category.name
            }
        }
    }
}