from numpy import dot
import matplotlib.pyplot as plt
import numpy as np
class Simple_iteration:
    def __init__(self, e: float = 0.0001):
        self.matrix_B = [
                         [-0.1, 0.2, -0.1],
                         [0.1, -0.2, -0.2],
                         [-0.2, 0.1, -0.1]
        ]
        self.size_of_matrix_B = len(self.matrix_B)
        self.matrix_C = [1.6, -2.3, 1.5]
        self.abs_sum_list = []
        self.e = e
        self.iterations = 0

    def norm(self) -> float:
        for row in range(self.size_of_matrix_B):
            abs_sum: float = 0
            for col in range(self.size_of_matrix_B):
                abs_sum += abs(
                    self.matrix_B[row][col])
            self.abs_sum_list.append(abs_sum)

        max_sum: float = 0
        for i in range(self.size_of_matrix_B):
            max_sum = self.abs_sum_list[i] if self.abs_sum_list[i] > max_sum else max_sum
        return max_sum

    def max(self, delta_x) -> float:
        max_value = 0
        for i in range(self.size_of_matrix_B):
            max_value = abs(delta_x)[i] if max_value < abs(delta_x)[i] else max_value
        return max_value

    def solution(self):
        norm = self.norm()
        q = norm
        x_0 = self.matrix_C
        flag = True

        while flag:
            m_x = dot(self.matrix_B, x_0) + self.matrix_C
            delta_x = m_x - x_0
            delta = self.max(delta_x)

            if (delta * q / (1 - q)) < self.e:
                flag = False
            x_0 = m_x
            self.iterations += 1

            if not flag: return x_0