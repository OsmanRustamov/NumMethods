import matplotlib.pyplot as plt
import numpy as np

class Newton_polynom():
    def __init__(self, x: np.ndarray, a: float):
        self.x = x
        self.a = a
        self.y = [self.func(num) for num in self.x]
        self.coef = self.divided_diff(self.x, self.y)
        self.point_a = self.newton_polynomial(self.a, self.coef, self.x)
    def func(self, x: float) -> float:
        return np.log(x) ** (11 / 7)

    def divided_diff(self, x: np.ndarray, y: np.ndarray) -> np.ndarray:
        n = len(x)
        F = np.zeros((n, n))
        F[:, 0] = y

        for j in range(1, n):
            for i in range(n - j):
                F[i, j] = (F[i + 1, j - 1] - F[i, j - 1]) / (x[i + j] - x[i])

        return F[0, :]

    def newton_polynomial(self, x: float, coef: np.ndarray, nodes: np.ndarray) -> np.float64:
        n = len(nodes)
        result = coef[0]

        for i in range(1, n):
            term = coef[i]
            for j in range(i):
                term *= (x - nodes[j])
            result += term

        return result

    def solution(self) -> str:
        interpolation_error = self.func(self.a) - self.point_a
        return f"Значение функции f(x) в точке a: {self.func(self.a)}\nЗначение полинома Ньютона в точке a: {self.point_a}\nПогрешность интерполяции: {interpolation_error}"

    def draw_graph(self):
        x_values = np.linspace(self.x[0], self.x[2], 100)
        y_values_f = self.func(x_values)
        y_values_p = self.newton_polynomial(x_values, self.coef, self.x)

        plt.plot(x_values, y_values_f, label='f(x)')
        plt.plot(x_values, y_values_p, label='Полином Ньютона')
        plt.scatter(self.x, self.y, color='red', label='Узлы интерполяции')
        plt.scatter(self.a, self.point_a, color='green', label='Значение полинома в точке a')
        plt.legend()
        plt.xlabel('x')
        plt.ylabel('y')
        plt.title('Интерполяционный полином Ньютона')
        plt.show()