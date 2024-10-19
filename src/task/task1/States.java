    package task.task1;

    public enum States {
        STRONGLY_TAKEN(true),      // 11
        WEAKLY_TAKEN(true),        // 10
        WEAKLY_NOT_TAKEN(false),    // 01
        STRONGLY_NOT_TAKEN(false);  // 00

        private final boolean value;

        // Constructor para asignar el valor a cada estado
        States(boolean value) {
            this.value = value;
        }

        // Método para obtener el valor numérico de cada estado
        public boolean getValue() {
            return value;
        }

        // Método para obtener el estado inicial (Weakly Taken por defecto)
        public static States getInitialState() {
            return WEAKLY_TAKEN;  // Estado inicial predeterminado
        }
    }
