import java.util.Scanner;

public class Ss03Asm03 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int countEmployee = 0;
            long salarySum = 0;
            long highestSalary = 0;
            long lowestSalary = 500000000;
            double bonusSalary = 0;

            while (true) {
                try {
                    System.out.println("============= MENU =============");
                    System.out.println("1. Nhập lương của nhân viên");
                    System.out.println("2. Hiển thị thống kê");
                    System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
                    System.out.println("4. Thoát");
                    System.out.print("Lựa chọn của bạn: ");
                    int choice = Integer.parseInt(input.nextLine());

                    switch (choice) {
                        case 1 -> {
                            System.out.println();
                            System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                            while (true) {
                                System.out.print("Nhập lương: ");
                                long salary = Long.parseLong(input.nextLine());

                                if (salary == -1) break;

                                if (salary < 0 || salary > 500000000) {
                                    System.out.println("Lương không hợp lệ. Nhập lại.");
                                    continue;
                                }

                                if (salary < 5000000) {
                                    System.out.println("Thu nhập thấp");
                                    bonusSalary += salary * 0.05;
                                } else if (salary < 15000000) {
                                    System.out.println("Thu nhập trung bình");
                                    bonusSalary += salary * 0.1;
                                } else if (salary < 50000000) {
                                    System.out.println("Thu nhập khá");
                                    bonusSalary += salary * 0.15;
                                } else {
                                    System.out.println("Thu nhập cao");
                                    bonusSalary += salary <= 100000000 ? salary * 0.2 : salary * 0.25;
                                }

                                countEmployee++;
                                salarySum += salary;
                                highestSalary = Math.max(highestSalary, salary);
                                lowestSalary = Math.min(lowestSalary, salary);
                            }
                        }

                        case 2 -> {
                            System.out.println();
                            if (countEmployee == 0) {
                                System.out.println("Chưa có dữ liệu");
                            } else {
                                System.out.println("--- Thống kê ---");
                                System.out.println("Số nhân viên: " + countEmployee);
                                System.out.printf("Tổng lương: %,d VND%n", salarySum);
                                System.out.printf("Lương trung bình: %,.0f VND%n", (double) salarySum / countEmployee);
                                System.out.printf("Lương cao nhất: %,d VND%n", highestSalary);
                                System.out.printf("Lương thấp nhất: %,d VND%n", lowestSalary);
                            }
                        }
                        case 3 -> {
                            System.out.println();
                            System.out.println("--- Tính tổng số tiền thưởng cho nhân viên ---");
                            System.out.printf("Tổng tiền thưởng nhân viên: %,.0f VND%n", bonusSalary);
                        }
                        case 4 -> {
                            System.out.println();
                            System.out.println("Kết thúc chương trình.");
                            System.exit(0);
                        }
                        default -> {
                            System.out.println();
                            System.err.println("Vui lòng chọn các chức năng từ 1 đến 4.");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.err.println("Vui lòng nhập giá trị số để chọn chức năng.");
                }
            }
        }
    }
}
