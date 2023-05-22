import numpy as np
import matplotlib.pyplot as plt
import math

class Lagrange():
    def __init__(self, x: list, a: float):
        self.x = x
        self.a = a
        self.y = [self.func(num) for num in x]
        self.coefficients = np.polyfit(self.x, self.y, len(self.x) - 1)
        self.lagrange_poly = np.poly1d(self.coefficients)
        self.lagrange_value = self.lagrange_poly(a)
        self.x_values = np.linspace(x[0], x[2], 100)
        self.f_values = [self.func(self.x) for self.x in self.x_values]
        self.lagrange_values = self.lagrange_poly(self.x_values)

    def func(self, x: float) -> float:
        return math.log(x)**(11 / 7)

    def solution(self) -> str:
        return f"Значение функции f(x) в точке a: {self.func(self.a)}\nЗначение полинома Лагранжа в точке a: {self.lagrange_value}\nПогрешность интерполяции: {abs(self.func(self.a) - self.lagrange_value)}"

    def draw_graph(self, x: list):
        plt.plot(self.x_values, self.lagrange_values, label='Полином Лагранжа')
        plt.plot(self.x_values, self.f_values, label='f(x)')
        plt.scatter(x, self.y, color='red', label='Узлы интерполяции')
        plt.scatter(self.a, self.lagrange_value, color='green', label='Значение полинома в точке a')
        plt.legend()
        plt.xlabel('x')
        plt.ylabel('y')
        plt.title('Интерполяциjyy полиномом Лагранжа')
        plt.grid(True)
        plt.show()