<template>
    <div>
        <form @submit.prevent="save">
            <div class="mb-2"><label>Mã</label><input v-model="form.id" type="number" class="form-control" /></div>
            <div class="mb-2"><label>Tên</label><input v-model="form.name" class="form-control" /></div>
            <div class="mb-2"><label>Giá</label><input v-model="form.price" type="number" class="form-control" /></div>
            <div class="mb-2"><label>Ngày</label><input v-model="form.date" type="date" class="form-control" /></div>
            <div class="mb-2">
                <label>Loại</label>
                <select v-model="form.category.id" class="form-control">
                    <option v-for="c in categories" :value="c.id" :key="c.id">{{ c.name }}</option>
                </select>
            </div>
            <button class="btn btn-primary">Lưu</button>
        </form>

        <hr />
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th>Ngày</th>
                    <th>Loại</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="p in products" :key="p.id">
                    <td>{{ p.id }}</td>
                    <td>{{ p.name }}</td>
                    <td>{{ p.price }}</td>
                    <td>{{ p.date }}</td>
                    <td>{{ p.category?.name }}</td>
                    <td>
                        <button @click="edit(p)" class="btn btn-warning btn-sm">Sửa</button>
                        <button @click="remove(p.id)" class="btn btn-danger btn-sm">Xóa</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import productService from '@/services/productService'
import categoryService from '@/services/categoryService'

const form = ref({ id: '', name: '', price: '', date: '', category: { id: null } })
const products = ref([])
const categories = ref([])

const load = async () => {
    products.value = await productService.getAll()
    categories.value = await categoryService.getAll()
}

const save = async () => {
    if (await productService.getById(form.value.id)) {
        await productService.update(form.value.id, form.value)
    } else {
        await productService.create(form.value)
    }
    form.value = { id: '', name: '', price: '', date: '', category: { id: null } }
    load()
}

const edit = (item) => {
    form.value = { ...item, category: { id: item.category?.id } }
}

const remove = async (id) => {
    await productService.remove(id)
    load()
}

onMounted(load)
</script>
