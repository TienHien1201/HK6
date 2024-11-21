<template>
  <div class="Container-Map">
    <iframe
      src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&q=Phường+10,+Quận+Gò+Vấp,+TP.HCM"
      width="250"
      height="500"
      frameborder="0"
      style="border: 0; width: 100%"
      allowfullscreen=""
    ></iframe>
  </div>
</template>

<script>
export default {
  name: 'ComMaps',
};
</script>

<style>
.Container-Map{
    padding-top: 50px;
}
</style>
