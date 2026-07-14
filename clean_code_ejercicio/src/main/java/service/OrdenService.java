package service;


    public class OrderService {

        private static final double DESCUENTO_ORDEN = 0.9;
        private static final String MENSAJE_CONFIRMACION_ORDER = "Tu pedido fue procesado";

        private final OrderRepository repositorioOrder;
        private final EmailService emailSvc;

        public OrderService(OrderRepository repositorioOrder, EmailService emailSvc) {
            this.repositorioOrder = repositorioOrder;
            this.emailSvc = emailSvc;
        }

        public void procesarOrder(Order order, boolean aplicarDescuento) {
            validarOrder(order);
            order.setTotal(calcularTotal(order, aplicarDescuento));
            guardarOrder(order);
            enviarEmailConfirmacion(order);
        }

        private void validarOrder(Order order) {
            if (order == null || order.getItems().isEmpty()) {
                throw new InvalidOrderException("La orden es nula o no tiene items");
            }
        }

        private double montoTotalItems(Order order) {
            double totalMonto = 0.0;
            for (Item item : order.getItems()) {
                totalMonto += item.getPrice() * item.getQuantity();
            }
            return totalMonto;
        }

        private double calcularTotal(Order order, boolean aplicarDescuento) {
            double totalMonto = montoTotalItems(order);
            return aplicarDescuento ? totalMonto * DESCUENTO_ORDEN : totalMonto;
        }

        private void guardarOrder(Order order) {
            repositorioOrder.save(order);
        }

        private void enviarEmailConfirmacion(Order order) {
            emailSvc.send(order.getUser().getEmail(), MENSAJE_CONFIRMACION_ORDER);
        }
    }