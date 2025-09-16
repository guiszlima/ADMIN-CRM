/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html",
    "./src/main/resources/static/js/**/*.js",
    "./src/main/java/**/*.java"
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms'), // Exemplo de um plugin
    require('@tailwindcss/typography'), // Outro exemplo
  ],
}