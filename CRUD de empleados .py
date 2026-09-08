class Empleado:
    def __init__(self, id_empleado, nombre, cargo, salario):
        self.id_empleado = id_empleado
        self.nombre = nombre
        self.cargo = cargo
        self.salario = salario

    def mostrar(self):
        print(f"ID: {self.id_empleado} | Nombre: {self.nombre} | Cargo: {self.cargo} | Salario: ${self.salario:,.2f}")


class GestorEmpleados:
    def __init__(self):
        self.empleados = []

    def crear_empleado(self, id_empleado, nombre, cargo, salario):
        if self.buscar_empleado(id_empleado):
            print("Ya existe un empleado con ese ID.")
            return
        nuevo = Empleado(id_empleado, nombre, cargo, salario)
        self.empleados.append(nuevo)
        print(f"Empleado {nombre} creado con exito.")

    def listar_empleados(self):
        if not self.empleados:
            print("No hay empleados registrados.")
            return
        print("\n--- Lista de Empleados ---")
        for emp in self.empleados:
            emp.mostrar()

    def buscar_empleado(self, id_empleado):
        for emp in self.empleados:
            if emp.id_empleado == id_empleado:
                return emp
        return None

    def actualizar_empleado(self, id_empleado, nombre=None, cargo=None, salario=None):
        emp = self.buscar_empleado(id_empleado)
        if not emp:
            print("Empleado no encontrado.")
            return
        if nombre:
            emp.nombre = nombre
        if cargo:
            emp.cargo = cargo
        if salario:
            emp.salario = salario
        print(f"Empleado {id_empleado} actualizado.")

    def eliminar_empleado(self, id_empleado):
        emp = self.buscar_empleado(id_empleado)
        if not emp:
            print("Empleado no encontrado.")
            return
        self.empleados.remove(emp)
        print(f"Empleado {id_empleado} eliminado.")


def menu():
    gestor = GestorEmpleados()
    while True:
        print("\n===== MENU EMPLEADOS =====")
        print("1. Crear empleado")
        print("2. Listar empleados")
        print("3. Buscar empleado")
        print("4. Actualizar empleado")
        print("5. Eliminar empleado")
        print("6. Salir")
        opcion = input("Elige una opcion: ")
        if opcion == "1":
            id_emp = input("ID: ")
            nombre = input("Nombre: ")
            cargo = input("Cargo: ")
            salario = float(input("Salario: "))
            gestor.crear_empleado(id_emp, nombre, cargo, salario)
        elif opcion == "2":
            gestor.listar_empleados()
        elif opcion == "3":
            id_emp = input("ID a buscar: ")
            emp = gestor.buscar_empleado(id_emp)
            if emp:
                emp.mostrar()
            else:
                print("No encontrado.")
        elif opcion == "4":
            id_emp = input("ID a actualizar: ")
            nombre = input("Nuevo nombre (Enter para dejar igual): ")
            cargo = input("Nuevo cargo (Enter para dejar igual): ")
            salario = input("Nuevo salario (Enter para dejar igual): ")
            salario = float(salario) if salario else None
            gestor.actualizar_empleado(id_emp, nombre or None, cargo or None, salario)
        elif opcion == "5":
            id_emp = input("ID a eliminar: ")
            gestor.eliminar_empleado(id_emp)
        elif opcion == "6":
            print("Hasta luego!")
            break
        else:
            print("Opcion no valida.")


if __name__ == "__main__":
    menu()
