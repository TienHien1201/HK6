<template>
  <div class="container_crud" >
    <form @submit.prevent="handleSubmit">
      <!-- Input Title -->
      <div class="mb-6">
        <label for="title" class="mb-2 block text-sm font-medium text-gray-900 dark:text-gray-300">
          Title
        </label>
        <input
          type="text"
          id="title"
          class="block w-full rounded-lg border border-gray-300 bg-gray-50 p-2.5 text-sm text-gray-900 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          placeholder="Title"
          v-model="formData.title"
          required
        />
      </div>

      <!-- Input Featured Image -->
      <div class="mb-6">
        <label for="featuredImage" class="mb-2 block text-sm font-medium text-gray-900 dark:text-gray-300">
          Featured Image
        </label>
        <input
          type="text"
          id="featuredImage"
          class="block w-full rounded-lg border border-gray-300 bg-gray-50 p-2.5 text-sm text-gray-900 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          placeholder="URL image"
          v-model="formData.featuredImage"
          required
        />
      </div>

      <!-- Textarea Description -->
      <div class="mb-6">
        <label for="description" class="mb-2 block text-sm font-medium text-gray-900 dark:text-gray-400">
          Description
        </label>
        <textarea
          id="description"
          rows="3"
          class="block w-full rounded-lg border border-gray-300 bg-gray-50 p-2.5 text-sm text-gray-900 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          placeholder="Your description..."
          v-model="formData.description"
          required
        ></textarea>
      </div>

      <!-- Input Publish Date -->
      <div class="mb-6">
        <label for="publishDate" class="mb-2 block text-sm font-medium text-gray-900 dark:text-gray-300">
          Publish Date
        </label>
        <input
          type="datetime-local"
          id="publishDate"
          class="block w-56 rounded-lg border border-gray-300 bg-gray-50 p-2.5 text-sm text-gray-900 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          v-model="formData.publishDate"
          required
        />
      </div>

      <!-- Checkbox Publish -->
      <div class="mb-6 flex items-center">
        <input
          id="publish"
          type="checkbox"
          class="h-4 w-4 focus:ring-2 focus:ring-blue-500"
          v-model="formData.published"
        />
        <label for="publish" class="ml-2 text-sm font-medium text-gray-900">
          Publish
        </label>
      </div>

      <!-- Buttons -->
      <div>
        <!-- Submit Button -->
        <button
          class="group relative inline-flex items-center justify-center overflow-hidden rounded-lg bg-gradient-to-br from-purple-600 to-blue-500 p-0.5 text-sm font-medium text-gray-900 hover:text-white focus:outline-none focus:ring-4 focus:ring-blue-300 group-hover:from-purple-600 group-hover:to-blue-500 dark:text-white dark:focus:ring-blue-800"
          type="submit"
        >
          <span class="relative rounded-md bg-white px-5 py-2.5 transition-all duration-75 ease-in group-hover:bg-opacity-0 dark:bg-gray-900">
            Publish Post
          </span>
        </button>

        <!-- Update Button -->
        <button
          type="button"
          class="group relative mb-2 mr-2 inline-flex items-center justify-center overflow-hidden rounded-lg bg-gradient-to-br from-teal-300 to-lime-300 p-0.5 text-sm font-medium text-gray-900 focus:outline-none focus:ring-4 focus:ring-lime-200 group-hover:from-teal-300 group-hover:to-lime-300 dark:text-white dark:hover:text-gray-900 dark:focus:ring-lime-800"
          @click="handleUpdate"
        >
          <span class="relative rounded-md bg-white px-5 py-2.5 transition-all duration-75 ease-in group-hover:bg-opacity-0 dark:bg-gray-900">
            Update Post
          </span>
        </button>

        <!-- Reset Button -->
        <button
          type="reset"
          class="group relative mb-2 mr-2 inline-flex items-center justify-center overflow-hidden rounded-lg bg-gradient-to-br from-red-200 via-red-300 to-yellow-200 p-0.5 text-sm font-medium text-gray-900 focus:outline-none focus:ring-4 focus:ring-red-100 group-hover:from-red-200 group-hover:via-red-300 group-hover:to-yellow-200 dark:text-white dark:hover:text-gray-900 dark:focus:ring-red-400"
        >
          <span class="relative rounded-md bg-white px-5 py-2.5 transition-all duration-75 ease-in group-hover:bg-opacity-0 dark:bg-gray-900">
            Cancel
          </span>
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'ComCrudProduct',
  data() {
    return {
      formData: {
        title: '',
        featuredImage: '',
        description: '',
        publishDate: '',
        published: false,
      },
    };
  },
  methods: {
    handleSubmit() {
      console.log('Submit form:', this.formData);
    },
    handleUpdate() {
      console.log('Update form:', this.formData);
    },
  },
};
</script>

<style>
.container-lienhe {
  background-color: #fff;
  padding-top: 50px;
}
</style>
