<script setup lang="ts">
import {defineProps, ref, onMounted} from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
const props = defineProps({
    postId: {
        type:Number,
        required:true,
    }
});

const post = ref({
  id: 0,
  title: "",
  content: "",
});
const router = useRouter();

onMounted(() => {
  axios.get(`/api/posts/${props.postId}`).then((response) => {
    post.value = response.data;
  });
});
</script>

<template>
    <h2>{{post.title}}</h2>
    <div>{{post.content}}</div>
</template>
<style>

</style>