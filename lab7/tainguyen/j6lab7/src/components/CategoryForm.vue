<template>
    <div>
        <form @submit.prevent="save">
            <div class="mb-3">
                <label>Mã loại</label>
                <input v-model="form.id" type="number" class="form-control" />
            </div>
            <div class="mb-3">
                <label>Tên loại</label>
                <input v-model="form.name" type="text" class="form-control" />
            </div>
            <button class="btn btn-primary">Lưu</button>
        </form>

        <hr />
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in categories" :key="item.id">
                    <td>{{ item.id }}</td>
                    <td>{{ item.name }}</td>
                    <td>
                        <button @click="edit(item)" class="btn btn-warning btn-sm">Sửa</button>
                        <button @click="remove(item.id)" class="btn btn-danger btn-sm">Xóa</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import categoryService from '@/services/categoryService'

const form = ref({ id: '', name: '' })
const categories = ref([])

const load = async () => {
    categories.value = await categoryService.getAll()
}

const save = async () => {
    if (await categoryService.getById(form.value.id)) {
        await categoryService.update(form.value.id, form.value)
    } else {
        await categoryService.create(form.value)
    }
    form.value = { id: '', name: '' }
    load()
}

const edit = (item) => {
    form.value = { ...item }
}

const remove = async (id) => {
    await categoryService.remove(id)
    load()
}

onMounted(load)
</script>
