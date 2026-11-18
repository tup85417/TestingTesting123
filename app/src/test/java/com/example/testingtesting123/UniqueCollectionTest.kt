package com.example.testingtesting123

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val item = Item("item1")

        collection.addItem(item)

        assertEquals(1, collection.size())
        assertSame(item, collection.get(0))
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    @Test
    fun addUniqueItem() {
        val firstItem = Item("item1")
        val secondItem = Item("item2")

        collection.addItem(firstItem)
        collection.addItem(Item("item1"))
        collection.addItem(Item("ITEM1"))
        collection.addItem(secondItem)

        assertEquals(2, collection.size())
        assertSame(firstItem, collection.get(0))
        assertSame(secondItem, collection.get(1))
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size()

        assertEquals(2, originalSize)
        assertEquals(0, newSize)
    }
}
