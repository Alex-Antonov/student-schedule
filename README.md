# student-schedule
**Проект "Студенческое расписание" в рамках обучения в школе LevelUp.**

*Описание:*
Программа для обеспечения удобства учета данных студентов и преподавателей, а так же облегчения процесса формирования расписания занятий.

Оператору данной системы предоставляется следующий функционал:
  - Возможность создавать новые группы;
  - Добавлять данные новых студентов и определять их в группу одного из потоков;
  - Просмотр/редактирование списка студентов по группам;
  - Создание/редактирование информации о преподавателях;
  - Формировать расписание, исходя из имеющихся данных в системе о группах и преподавателях.
  
*TODO*
В следующих версиях программы планируется добавить:
  - Роли студентов и преподавателей;
  - Возможность просмотра своего расписания;
  - Для преподавателей будет введен функционал учета успеваемости каждого студента;
  - Студенты смогут всегда знать, как обстаят у них дела с каждым из предметов.

Сценарии использования:
В минимальном функционла для роли оператора предусмотрено 10 возможных сценариев:
  - авторизация в системе;
  - просмотр списка преподавателей;
  - просмотр списка студентов групы;
  - просмотр списка групп;
  - просмотр списка потоков;
  - добавление новых преподавателей;
  - добавление новых студентов;
  - добавление новых групп;
  - добавление новых потоков;
  - формирование расписания.

![UC diagram](https://github.com/Alex-Antonov/student-schedule/blob/master/use%20case%20operator%20diagram.png)
***
**Модель данных**
Модель данных включает в себя следующие сущности:

| Сущность  |Описание                                                                                                   |
| ---       | ---                                                                                                       |
| User      |   Сущность пользователя содержит информацию, необходимую для авторизации, и привязку к сущности Person    |
| Person    |   Содержит базовую и контактную информацию, которая одинакова как для студентов, так и для преподавателей |
| PersonType|   Таблица-словарь с типами Person: STUDENT, TUTOR                                                         |
| Student   |   Таблица с информацией о студентах                                                                       |
| Group     |   Группа студентов                                                                                        |
| Flow      |   Потоки групп                                                                                            |
| Tutor     |   Информация о преподавателях                                                                             |
| Subject   |   Предметы, дисциплины                                                                                    |
| ClassTime |   Таблица-словарь, содержащая допустимые периоды времени проведения занятий                               |
| Degree    |   Таблица словарь с допустимыми значениями званий и регалий преподавателей                                |
| Schedule  |   Расписание занятий                                                                                      |

![UC diagram](https://github.com/Alex-Antonov/student-schedule/blob/master/model.png)
