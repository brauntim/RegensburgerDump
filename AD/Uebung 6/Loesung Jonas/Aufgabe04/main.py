# Löst mit Durchschnittslaufzeit n^2
def rucksackproblem (werte, gewichte, anzahl_werteUndGewicht, maximalgewicht):
    werte_gewichte_ratio = []

    werte_gewichte_ratio.append(
        werte[0] / gewichte[0]
    )

    for current_position in range(1, anzahl_werteUndGewicht):
        werte_gewichte_ratio.append(
            werte[current_position] / gewichte[current_position]
        )

        if werte_gewichte_ratio[current_position] < werte_gewichte_ratio[current_position-1]:
            swap_wert = werte[current_position]
            werte[current_position] = werte[current_position-1]
            werte[current_position-1] = swap_wert

            swap_gewicht = gewichte[current_position]
            gewichte[current_position] = gewichte[current_position-1]
            gewichte[current_position-1] = swap_gewicht

            swap_wertGewichtRatio = werte_gewichte_ratio[current_position]
            werte_gewichte_ratio[current_position] = werte_gewichte_ratio[current_position-1]
            werte_gewichte_ratio[current_position-1] = swap_wertGewichtRatio

    for position_of_lastSortedValue in range(anzahl_werteUndGewicht-1, 1, -1):
        for current_position in range(1, position_of_lastSortedValue):
            if werte_gewichte_ratio[current_position] < werte_gewichte_ratio[current_position-1]:
                swap_wert = werte[current_position]
                werte[current_position] = werte[current_position-1]
                werte[current_position-1] = swap_wert

                swap_gewicht = gewichte[current_position]
                gewichte[current_position] = gewichte[current_position-1]
                gewichte[current_position-1] = swap_gewicht

                swap_wertGewichtRatio = werte_gewichte_ratio[current_position]
                werte_gewichte_ratio[current_position] = werte_gewichte_ratio[current_position-1]
                werte_gewichte_ratio[current_position-1] = swap_wertGewichtRatio
    
    gewaehlte_gewichte = []

    current_gewicht = 0
    for current_position in range(anzahl_werteUndGewicht-1, -1, -1):
        moegliche_gewichtung = 1

        if current_gewicht + gewichte[current_position] > maximalgewicht:
            moegliche_gewichtung = (maximalgewicht - current_gewicht) / gewichte[current_position]
        
        current_gewicht += moegliche_gewichtung * gewichte[current_position]
        gewaehlte_gewichte.append(
            {
                "wert": werte[current_position],
                "gewicht": gewichte[current_position],
                "gewichtung": moegliche_gewichtung
            }
        )

    return

def main ():
    werte = [2, 3, 4]
    gewichte = [1, 2, 6]

    rucksackproblem(werte, gewichte, 3, 4)
    
    pass

main()