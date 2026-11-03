/* =========================================================
   TomatTree — Lógica e Interacción Frontend (main.js)
   ========================================================= */

document.addEventListener('DOMContentLoaded', () => {

    // 1. Scroll suave para enlaces del menú
    const enlacesNav = document.querySelectorAll('a[href^="#"]');
    enlacesNav.forEach(enlace => {
        enlace.addEventListener('click', function (e) {
            const targetId = this.getAttribute('href');
            if (targetId !== "#" && document.querySelector(targetId)) {
                e.preventDefault();
                const seccionObjetivo = document.querySelector(targetId);
                
                // Cierra el menú móvil si está abierto
                const menuBootstrap = document.getElementById('menuPrincipal');
                if (menuBootstrap && menuBootstrap.classList.contains('show')) {
                    const bsCollapse = bootstrap.Collapse.getInstance(menuBootstrap);
                    if (bsCollapse) bsCollapse.hide();
                }

                seccionObjetivo.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // 2. Control del formulario de Inicio de Sesión (login.html)
    const formLogin = document.getElementById('formLogin');
    if (formLogin) {
        formLogin.addEventListener('submit', (e) => {
            e.preventDefault();
            const correo = document.getElementById('correo').value;
            
            alert(`¡Bienvenido a TomatTree Mayorista!\nSesión iniciada correctamente con: ${correo}`);
            window.location.href = 'index.html';
        });
    }

    // 3. Contador interactivo de Pedidos (catalogo.html)
    let cantidadProductos = 0;
    const contadorCarrito = document.getElementById('contadorCarrito');
    const botonesAgregar = document.querySelectorAll('.btn-agregar');

    botonesAgregar.forEach(boton => {
        boton.addEventListener('click', () => {
            cantidadProductos++;
            if (contadorCarrito) {
                contadorCarrito.textContent = `🛒 Pedido: ${cantidadProductos} item(s)`;
                contadorCarrito.classList.remove('bg-secondary');
                contadorCarrito.classList.add('bg-success');
            }
            alert('Producto añadido al borrador de pedido B2B.');
        });
    });

    console.log('✅ JavaScript de TomatTree cargado correctamente.');
});