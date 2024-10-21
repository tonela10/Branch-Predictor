    package beans.tasks;

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

        /* Possible improvement to make the code scalabe
	    In this way i can update the States easily using the last outcome and actual state
	    with just one function into the enum

        public States nextValue(boolean taken) {
            return switch (this) {
                case STRONGLY_TAKEN if taken -> null;
                case STRONGLY_TAKEN -> null;

                    case WEAKLY_TAKEN -> null;
                case WEAKLY_NOT_TAKEN -> null;
                case STRONGLY_NOT_TAKEN -> null;
            }

         */

    }
