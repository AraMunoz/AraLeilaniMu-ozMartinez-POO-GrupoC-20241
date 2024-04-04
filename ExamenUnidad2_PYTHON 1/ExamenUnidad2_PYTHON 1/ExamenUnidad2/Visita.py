from Visitantes import Visitantes

class Visita:
    IDENTIFICADOR = 90
    guia_cargo = None
    costo_total = None
    cantidad_niños = 0
    cantidad_adultos = 0
    fecha_de_la_visita = None
    id_visita = 0
    lista_de_visitantes = []

    def __init__(self, id_guia=None, fecha_de_la_visita=None, cantidad_adultos=None, cantidad_niños=None):
        if id_guia is not None and fecha_de_la_visita is not None and cantidad_adultos is not None and cantidad_niños is not None:
            self.id_guia = id_guia
            self.fecha_de_la_visita = fecha_de_la_visita
            self.cantidad_adultos = cantidad_adultos
            self.cantidad_niños = cantidad_niños
        else:
            # Aquí maneja el caso donde no se proporcionan todos los argumentos
            pass
    

    
    def calcular_costo_total(self, lista_de_visitantes = []):
        costo_adulto = 100
        costo_nino = 50
        total_adultos = 0
        total_ninos = 0

        for visitante in lista_de_visitantes:
            if visitante.calcular_edad() >= 18:
                 total_adultos += 1
            else:
                total_ninos += 1
                
        costo_total = (total_adultos * costo_adulto) + (total_ninos * costo_nino)

        descuento = 1 - sum(visitante.obtener_descuento() for visitante in lista_de_visitantes)
        costo_final = costo_total * descuento
        print(descuento)
        return costo_final

    def agregar_visitante(self, visitante):
        self.lista_de_visitantes.append(visitante)

    def get_guia_cargo(self):
        return self.guia_cargo

    def set_guia_cargo(self, guia_cargo):
        self.guia_cargo = guia_cargo

    def get_fecha_de_la_visita(self):
        return self.fecha_de_la_visita

    def get_id_visita(self):
        return self.id_visita

    def get_cantidad_adultos(self):
        return self.cantidad_adultos

    def get_cantidad_niños(self):
        return self.cantidad_niños
