https://docs.spring.io/spring-statemachine/docs/2.0.2.RELEASE/reference/htmlsingle/#sm-context

有限状态机，（英语：Finite-state machine, FSM），又称有限状态自动机，简称状态机，是表示有限个状态以及在这些状态之间的转移和动作等行为的数学模型。

有限状态机体现了两点：首先是离散的，然后是有限的。

State：状态这个词有些难以定义，状态存储关于过去的信息，就是说它反映从系统开始到现在时刻的输入变化。
Actions & Transitions：转换指示状态变更，并且用必须满足来确使转移发生的条件来描述它。动作是在给定时刻要进行的活动的描述。
Guards:检测器出现的原因是为了检测是否满足从一个状态切换到另外一个状态的条件。
Event：事件，又见事件，笼统说来，对系统重要的某件事情被称为事件。

turnstile示例说明：
旋转门被视为状态机，有两种可能的状态：锁定和解锁。有两种可能影响其状态的输入：将硬币放入槽（硬币）并推动手臂（推动）。在锁定状态下，推动手臂无效; 无论输入推送次数多少，它都处于锁定状态。投入硬币 - 即给机器输入硬币 - 将状态从锁定转换为解锁。在解锁状态下，放入额外的硬币无效; 也就是说，给予额外的硬币输入不会改变状态。然而，顾客推动手臂，进行推动输入，将状态转回Locked。
CurrentState Input NextState Output
Locked		 coin  nlocked   解锁旋转门，以便游客能够通过
Locked 		 push  Locked    None
Unlocked     coin  Unlocked  None
Unlocked     push  Locked    当游客通过，锁定旋转门
